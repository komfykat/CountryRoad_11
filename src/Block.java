import java.awt.*;
import java.util.ArrayList;

public class Block {
    ArrayList<Path> paths;
    double x;
    double y;
    double width;
    double height;

    public Block(ArrayList<Path> paths, double x, double y, double width, double height) {
        this.paths = paths;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        g.drawRect((int) x, (int) y, (int) width, (int) height);
        for (Path path: paths){
            path.paint(g);
            for (int i = 0; i < path.n - 1; ++i) {
                g.setColor(Color.black);
                g.drawLine(path.getXs().get(i).intValue(), path.getYs().get(i).intValue(), path.getXs().get(i + 1).intValue(), path.getYs().get(i + 1).intValue());
            }
        }
    }

}
