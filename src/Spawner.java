import java.util.ArrayList;

public class Spawner {
    public double x;
    public double y;
    public Car blankcar;
    public Car car;
    public double time;
    public double spawnTime;

    public Spawner(double x, double y, Car blankcar, double spawnTime) {
        this.x = x;
        this.y = y;
        this.blankcar = blankcar;
        this.spawnTime = spawnTime;
    }

    public void updateCars(ArrayList<Car> cars, ArrayList<Block> blocks) {
        if (time >= spawnTime) {
            if (car != null) {
                if (Math.sqrt(Math.pow(Math.abs(car.getX() - x), 2) +  Math.pow(Math.abs(car.getY() - y), 2)) <= car.getV() * 1000 / 1000) {
                    time += Constants.tick * 1000;
                }
                else{
                    car = null;
                }
            } else {
                Car car1 = blankcar.copy();
                car1.setX(x);
                car1.setY(y);
                car1.blocks = blocks;
                if (car1.ifBlock()) {
                    car1.findNextBlock();
                    cars.add(car1);
                    car1.cars = cars;
                    car = car1;
                    time = 0;
                }
            }
        } else {
            time += Constants.tick * 1000;
        }
    }
}
