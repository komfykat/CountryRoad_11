import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Billboard extends JPanel {
    Car car;
    ArrayList<Car> cars;
    ArrayList<Block> blocks;
//    Billboard(ArrayList<Car> cars, ArrayList<Block> blocks, Car car){
//        this.cars = cars;
//        this.blocks = blocks;
//        this.car = car;
//    }
Billboard(Car car){
        this.car = car;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        car.paint(g);
    }

}
