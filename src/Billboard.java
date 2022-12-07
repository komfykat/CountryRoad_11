import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Billboard extends JPanel {
    Car car;
    ArrayList<Car> cars;
    ArrayList<Path> paths;

    Billboard(ArrayList<Car> cars, ArrayList<Path> paths) {
        this.cars = cars;
        this.paths = paths;
    }

    Billboard(Car car, ArrayList<Path> paths) {
        this.car = car;
        this.paths = paths;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars){
            car.paint(g);
        }
        for (Path path: paths){
            path.paint(g);
        }
    }

}
