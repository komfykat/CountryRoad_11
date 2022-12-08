import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random(1);
        Path path = new Path(new ArrayList<Double>(List.of(0.0, 50.0, 100.0)), new ArrayList<Double>(List.of(50.0, 50.0, 50.0)), Color.red);
        ArrayList<Path> paths = new ArrayList<Path>(List.of(path));
        Block StraightBlock = new Block(paths, 0, 0, 100, 100);
        Car car = new Car(0, 0, 20, 20, 20, path, StraightBlock);
        ArrayList<Car> cars = new ArrayList<Car>();
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Billboard board = new Billboard(cars, new ArrayList<Block>(List.of(StraightBlock)));
        frame.add(board);
        frame.setVisible(true);
//        for (int i = 0; i < cars.size(); ++i){
//            for (int j = i + 1; j < cars.size(); ++ j){
//                ArrayList<Integer> pair = new ArrayList<>(List.of(i, j, r.nextInt(2)));
//                pairs.add(pair);
//            }
//        }
        while (true){
//            for (ArrayList<Integer> pair : pairs){
//                Car cari = cars.get(pair.get(0));
//                Car carj = cars.get(pair.get(1));
//                int f = pair.get(2);
//
//                if (cari.check(carj)){
//                    System.out.println("Check");
//                    if (f == 0){
//                        cari.stop();
//                        carj.move();
//                    }
//                    if (f == 1){
//                        carj.stop();
//                        cari.move();
//                    }
//                }
//                else{
//                    cari.move();
//                    carj.move();
//                }
//
//            }
            for (Car cari : cars){
                cari.update();
            }
            frame.repaint();
            Thread.sleep(17);
        }


    }

}
