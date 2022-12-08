import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Billboard extends JPanel {
    Car car;
    ArrayList<Car> cars;
    ArrayList<Block> blocks;

    Billboard(ArrayList<Car> cars, ArrayList<Block> blocks) {
        this.cars = cars;
        this.blocks = blocks;
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars){
            car.paint(g);
        }
        for (Block block: blocks){
            block.paint(g);
        }
    }

}
