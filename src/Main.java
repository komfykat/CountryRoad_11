import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random(1);
        Car blankcar = new Car(30, 5, 5);
        Spawner spawner = new Spawner(0,  55, blankcar, 2000, 0);
        Spawner spawner1 = new Spawner(200, 45, blankcar, 2000, 1);
        HBlock block = new HBlock(0, 0, 100, 100);
        HBlock block1 = new HBlock(100, 0, 100, 100);
        ArrayList<Block> blocks = new ArrayList<>(List.of(block, block1));
        BlockGraph bg = new BlockGraph(blocks);
        System.out.println(bg.shortestPath(0));
        ArrayList<Spawner> spawners = new ArrayList<>(List.of(spawner, spawner1));
        ArrayList<Car> cars = new ArrayList<>();
        Despawner despawner = new Despawner(200, 55, cars, 0);
        Despawner despawner1 = new Despawner(0, 45, cars, 1);
        ArrayList<Despawner> despawners = new ArrayList<>(List.of(despawner, despawner1));
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Billboard board = new Billboard(cars, blocks);
        frame.add(board);
        frame.setVisible(true);

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
