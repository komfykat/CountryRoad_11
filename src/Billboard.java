import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Billboard extends JFrame implements MouseListener, MouseMotionListener {
    Car car;
    ArrayList<Car> cars;
    ArrayList<Block> blocks;
    Button button;

    Billboard(ArrayList<Car> cars, ArrayList<Block> blocks) {
        this.cars = cars;
        this.blocks = blocks;
        this.button = new Button(500, 500, 100, 100);
        setSize(1920, 1080);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            bufferStrategy = getBufferStrategy();
        }
        g = bufferStrategy.getDrawGraphics();
        super.paint(g);
        for (Car car : cars) {
            car.paint(g);
        }
        for (Block block : blocks) {
            block.paint(g);
        }
        button.paint(g);
        g.dispose();                // Освободить все временные ресурсы графики (после этого в нее уже нельзя рисовать)
        bufferStrategy.show();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
