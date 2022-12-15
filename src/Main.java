import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LRBlock block1 = new LRBlock(100, 0, 100, 100);
        LRBlock block2 = new LRBlock(200, 0, 100, 100);
        LDBlock block3 = new LDBlock(300, 0, 100, 100);
        ULBlock block4 = new ULBlock(300, 100, 100, 100);
        RLBlock block5 = new RLBlock(200, 100, 100, 100);
        RLBlock block6 = new RLBlock(100, 100, 100, 100);
        RUBlock block7 = new RUBlock(0, 100, 100, 100);
        DRBlock block8 = new DRBlock(0, 0, 100, 100);
        ArrayList<Block> blocks = new ArrayList<>(List.of(block1, block2, block3, block4, block5, block6, block7, block8));
        Car car = new Car(0, 50, 100, 10, 10, block1.paths.get(0), block1, blocks);
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car);
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Billboard board = new Billboard(cars, blocks);
        frame.add(board);
        frame.setVisible(true);

        while (true){
            for (Car cari : cars){
                cari.update();
            }
            frame.repaint();
            System.out.println(car.BlockX + " " + car.BlockY + " " + car.inPath + " " + car.inMotion + " " + car.PathPosition);
            Thread.sleep((long) (Constants.tick * 1000));
        }


    }

}
