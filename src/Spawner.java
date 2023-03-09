import java.util.ArrayList;
import java.util.List;

public class Spawner {
    public double x;
    public double y;
    public Car blankcar;
    public Car car;
    public double time;
    public double spawnTime;
    public int number;
    public ArrayList<Integer> GlobalPath;
    public BlockGraph bg;
    public boolean isOk;
    public ArrayList<Despawner> despawners;
    public ArrayList<Despawner> nicedespawners;
    public int bgnumber;

    public Spawner(double x, double y, Car blankcar, double spawnTime, int number, ArrayList<Despawner> despawners, BlockGraph bg) {
        this.x = x;
        this.y = y;
        this.blankcar = blankcar;
        this.spawnTime = spawnTime;
        this.number = number;
        this.despawners = despawners;
        this.bg = bg;
        bgnumber = bg.points.indexOf(new ArrayList<>(List.of(x, y)));
        makenicedespawners();
        this.GlobalPath = GetGlobalPath();
    }

    public void updateCars(ArrayList<Car> cars, ArrayList<Block> blocks) {
        if (time >= spawnTime) {
            if (car != null) {
                if (Math.sqrt(Math.pow(Math.abs(car.getX() - x), 2) + Math.pow(Math.abs(car.getY() - y), 2)) <= car.getV() * 1000 / 1000) {
                    time += Constants.tick * 1000;
                } else {
                    car = null;
                }
            } else {
                Car car1 = new Car(blankcar.getV(), blankcar.getWidth(), blankcar.getHeight(), this);
                    car1.findNextBlock();
                    cars.add(car1);
                    car1.cars = cars;
                    car = car1;
                    car.number = this.number;
                    time = 0;
                }
        } else {
            time += Constants.tick * 1000;
        }
    }

    public void makenicedespawners() {
        nicedespawners = new ArrayList<Despawner>();
        for (Despawner despawner : despawners) {
            if (despawner.number == this.number) {
                nicedespawners.add(despawner);
            }
        }
    }

    public ArrayList<Integer> GetGlobalPath() {
        if (nicedespawners.size() > 0) {
            int despawnermin = 0;
            double dmin = 1000000000;
            for (Despawner despawner : nicedespawners) {
                int bgdespawnernumber = bg.points.indexOf(new ArrayList<>(List.of(despawner.x, despawner.y)));
                double d = bg.shortestPathDistance(bgnumber, bgdespawnernumber);
                if (d < dmin) {
                    despawnermin = bgdespawnernumber;
                    dmin = d;
                }
            }
            if (dmin == 1000000000) {
                System.out.println("No Global Path! Rebuild your road!");
                return new ArrayList<Integer>();
            }
            return (bg.shortestPath(bgnumber, despawnermin));
        } else {
            System.out.println("No Finish! Rebuild your road!");
            return new ArrayList<Integer>();
        }
    }
}
