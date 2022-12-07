import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random(1);
        ArrayList<Double> Xs = new ArrayList<>(List.of(400.0, 800.0, 600.0, 200.0, 300.0));
        ArrayList<Double> Ys = new ArrayList<>(List.of(400.0, 100.0, 700.0, 500.0, 239.0));
        ArrayList<Double> Xs1 = new ArrayList<>(List.of(600.0, 900.0, 200.0, 200.0, 239.0));
        ArrayList<Double> Ys1 = new ArrayList<>(List.of(400.0, 100.0, 700.0, 710.0, 239.0));
        ArrayList<Double> Xs2 = new ArrayList<>(List.of(500.0, 300.0, 850.0, 200.0, 500.0));
        ArrayList<Double> Ys2 = new ArrayList<>(List.of(500.0, 400.0, 700.0, 100.0, 409.0));
        Path path = new Path(Xs, Ys, Color.red);
        Path path1 = new Path(Xs1, Ys1, Color.blue);
        Path path2 = new Path(Xs2, Ys2, Color.green);
        Car car = new Car(200, 200, 200, 50, 50, 0, path);
        Car car1 = new Car(300, 300, 200, 50, 50, 0, path1);
        Car car2 = new Car(400, 400, 200, 50, 50, 0, path2);
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>(List.of(car, car1, car2));
        ArrayList<Path> paths = new ArrayList<>(List.of(path, path1, path2));
        JFrame frame = new JFrame();
        frame.setSize(2560, 1440);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Billboard board = new Billboard(cars, paths);
        frame.add(board);
        frame.setVisible(true);
        for (int i = 0; i < cars.size(); ++i){
            Car cari = cars.get(i);
            for (int j = i + 1; j < cars.size(); ++ j){
                Car carj = cars.get(j);
                ArrayList<Integer> pair = new ArrayList<>(List.of(i, j, r.nextInt(2)));
                pairs.add(pair);
            }
        }
        while (true){
            frame.repaint();
            for (ArrayList<Integer> pair : pairs){
                Car cari = cars.get(pair.get(0));
                Car carj = cars.get(pair.get(1));
                int f = pair.get(2);
                if (cari.check(carj)){
                        if (f == 0){
                            cari.stop();
                        }
                        if (f == 1){
                            carj.stop();
                        }
                    }
                    else{
                        cari.move();
                        carj.move();
                    }

            }
            for (Car cari : cars){
                cari.update();
            }
            Thread.sleep(17);
        }


    }

}
