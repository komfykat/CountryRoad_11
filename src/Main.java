import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random(1);
//        Crossroad crossroad = new Crossroad(100, 100, 100, 100);
        Car blankcar = new Car(30, 10, 10);
        Car blankcar1 = new Car(30, 10, 10);
        Spawner spawner = new Spawner(45,  0, blankcar, 2000);
        ULBlock block = new ULBlock(0, 0, 100, 100);
        ArrayList<Block> blocks = new ArrayList<>(List.of(block));
        ArrayList<Spawner> spawners = new ArrayList<>(List.of(spawner));
        ArrayList<Car> cars = new ArrayList<>();
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
            frame.repaint();
            Thread.sleep((long) (Constants.tick * 1000));
        }


    }

}
