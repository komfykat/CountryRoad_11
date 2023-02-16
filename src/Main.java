import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random(1);
        Car blankcar = new Car(30, 5, 5);
        Spawner spawner = new Spawner(0,  55, blankcar, 2000);
        Spawner spawner1 = new Spawner(400, 45, blankcar, 2000);
        HBlock block = new HBlock(0, 0, 100, 100);
        HBlock block1 = new HBlock(100, 0, 100, 100);
        HBlock block2 = new HBlock(200, 0, 100, 100);
        HBlock block3 = new HBlock(300, 0, 100, 100);
        ArrayList<Block> blocks = new ArrayList<>(List.of(block, block1, block2, block3));
        ArrayList<Spawner> spawners = new ArrayList<>(List.of(spawner, spawner1));
        ArrayList<Car> cars = new ArrayList<>();
        Despawner despawner = new Despawner(400, 55, cars);
        Despawner despawner1 = new Despawner(0, 45, cars);
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
