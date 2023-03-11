import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Button {
    public double x;
    public double y;
    public double width;
    public double height;
    public Image image;

    public Button(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g){
        g.fillRect((int) x, (int) y, (int) width, (int) height);
    }
    public boolean onMouseHit(int mouseX, int mouseY){
        Rectangle2D B = new Rectangle2D.Double(x, y, width, height);
        if (B.contains(mouseX, mouseY)){
            System.out.println("Button hit!");
            return true;
        }
        else{
            return false;
        }
    }
}
