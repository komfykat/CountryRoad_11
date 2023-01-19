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
        double x = 100;
        double y = 100;
        double carx = 150;
        double cary = 100;
        double vx = 100;
        double vy = 0;
        double carvx = 0;
        double carvy = 0;
        Vector3D a = new Vector3D(vx, vy, 0);
        Vector3D b = new Vector3D(carvx, carvy, 0);
        Rectangle2D k = new Rectangle2D.Double(100 - 0.1, 100 - 0.1, vx + 0.1, vy + 0.1);
        Rectangle2D l = new Rectangle2D.Double(150 - 0.1, 100 - 0.1, 0.1, 0.1);
        System.out.println(a.right(b));
        System.out.println(k.intersects(l));
        Random r = new Random(1);
        Crossroad crossroad = new Crossroad(100, 100, 100, 100);
        ArrayList<Block> blocks = new ArrayList<>(List.of(crossroad));
        int i = r.nextInt(12);
        int j = r.nextInt(12);
        while (i == j){
            j = r.nextInt(12);
        }
//        int k = r.nextInt(12);
//        while (k == i || k == j){
//            k = r.nextInt(12);
//        }
        i = 0;
        j = 9;
        Car car = new Car(crossroad.paths.get(i).getXs().get(0), crossroad.paths.get(i).getYs().get(0), 30, 10, 10, crossroad.paths.get(i), crossroad, blocks);
        Car car1 = new Car(crossroad.paths.get(j).getXs().get(0), crossroad.paths.get(j).getYs().get(0), 30, 10, 10, crossroad.paths.get(j), crossroad, blocks);
//        Car car2 = new Car(crossroad.paths.get(k).getXs().get(0), crossroad.paths.get(k).getYs().get(0), 30, 10, 10, crossroad.paths.get(k), crossroad, blocks);
        ArrayList<Car> cars = new ArrayList<>(List.of(car, car1));
        car.cars = cars;
        car1.cars = cars;
//        car2.cars = cars;
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
            frame.repaint();
            Thread.sleep((long) (Constants.tick * 1000));
        }


    }

}
