import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random(1);
        for (int i = 0; i < 10; i ++) {
            System.out.println(r.nextInt(0, 2));
        }
        Car blankcar = new Car(50, 5, 5);
        Crossroad block = new Crossroad(0, 100, 100, 100);
        ULBlock block3= new ULBlock(0, 200, 100, 100);
        DLBlock block4 = new DLBlock(0, 0, 100, 100);
        DRBlock block5 = new DRBlock(200, 0, 100, 100);
        HBlock block1 = new HBlock(100, 100, 100, 100);
        Crossroad cs = new Crossroad(200, 100, 100, 100);
        URBlock block2 = new URBlock(200, 200, 100, 100);
        ArrayList<Block> blocks = new ArrayList<>(List.of(block, block1, cs, block2, block3, block4, block5));
        BlockGraph bg = new BlockGraph(blocks);
        ArrayList<Car> cars = new ArrayList<>();
        Despawner despawner = new Despawner(300, 155, cars, 0);
        Despawner despawner1 = new Despawner(300, 255, cars, 1);
        Despawner despawner2 = new Despawner(300, 55, cars, 2);
        ArrayList<Despawner> despawners = new ArrayList<>(List.of(despawner, despawner1, despawner2));
        Spawner spawner = new Spawner(0,  155, blankcar, 2000, 0, despawners, bg);
        Spawner spawner1 = new Spawner(0, 255, blankcar, 2000, 1, despawners, bg);
        Spawner spawner2 = new Spawner(0, 55, blankcar,2000, 2, despawners, bg);
        ArrayList<Spawner> spawners = new ArrayList<>(List.of(spawner, spawner1, spawner2));
        Billboard frame = new Billboard(cars, blocks);
        while (true){
            for (Car cari : cars) {
                cari.update();
            }
            for (Spawner spawneri : spawners){
                    spawneri.updateCars(cars, blocks);
            }
            for (Despawner despawneri : despawners){
                despawneri.cars = cars;
                cars = despawneri.update();
            }
            frame.repaint();
            Thread.sleep((long) (Constants.tick * 1000));
        }


    }

}
