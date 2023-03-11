import java.awt.*;
import java.util.ArrayList;

public class Block {
    ArrayList<Path> paths;
    double x;
    double y;
    double width;
    boolean isCrossroad = false;
    double height;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Block(ArrayList<Path> paths, double x, double y, double width, double height) {
        this.paths = paths;
        for (Path path: paths){
            path.block = this;
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Block(Path path, double x, double y, double width, double height) {
        paths = new ArrayList<>();
        paths.add(path);
        path.block = this;
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
                g.drawLine(path.getXs().get(i).intValue() + (int) x, path.getYs().get(i).intValue() +(int) y, path.getXs().get(i + 1).intValue() +(int) x, path.getYs().get(i + 1).intValue() +(int)y );
            }
        }
    }
    public void updatePaths(){
        for (Path path : paths){
            path.block = this;
        }
    }

}
