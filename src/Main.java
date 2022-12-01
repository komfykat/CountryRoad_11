import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Double> Xs = new ArrayList<Double>(List.of(400.0, 500.0, 600.0));
        ArrayList<Double> Ys = new ArrayList<Double>(List.of(400.0, 100.0, 700.0));
        Path path = new Path(Xs, Ys);
        Car car = new Car(200, 200, 75, 50, 50, 0, path);
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Billboard board = new Billboard(car, path);
        frame.add(board);
        frame.setVisible(true);
        while (true){
            frame.repaint();
            car.update();
            Thread.sleep(100);
        }


    }

}
