import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Car {
    private double x;
    private double y;
    private double v;
    private double angle;
    private double width;
    private double height;
    private Path path;
    private int position = 0;
    private boolean inMotion = true;
    private boolean inPath = true;
    public double stopTime = 0;

    public Car(double x, double y, double v, double width, double height, double angle, Path path) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.angle = angle;
        this.width = width;
        this.height = height;
        this.path = path;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void update() {
        if (inPath) {
            if (inMotion) {
                stopTime = 0;
                double nextX = path.getXs().get(position);
                double nextY = path.getYs().get(position);
                double vx = v * (nextX - x) / Math.sqrt(Math.pow(nextX - x, 2) + Math.pow(nextY - y, 2));
                double vy = v * (nextY - y) / Math.sqrt(Math.pow(nextX - x, 2) + Math.pow(nextY - y, 2));
                x += vx * 0.017;
                y += vy * 0.017;
                if (Math.abs(x - nextX) <= 5 && Math.abs(y - nextY) <= 5 && position < path.n) {
                    position++;
                }
                if (Math.abs(x - nextX) <= 5 && Math.abs(y - nextY) <= 5 && position == path.n) {
                    inPath = false;
                }
            }
        } else {
            stopTime += 17;
        }
    }

    public void stop() {
        inMotion = false;
    }

    public void move() {
        inMotion = true;
    }

    public double distance(Car car) {
        return Math.sqrt(Math.pow(x - car.x, 2) + Math.pow(y - car.y, 2));
    }

    public boolean check(Car car) {
        if (distance(car) < 200) {
            return true;
        } else {
            return false;
        }
    }

    public void paint(Graphics g) {
//        Graphics2D g2 = (Graphics2D)g;
//        double x1 = x - Math.cos(angle) * width / 2 + Math.cos(Math.PI / 2 - angle) * height / 2;
//        double y1 = y - Math.sin(angle) * width / 2 + Math.sin(Math.PI / 2 - angle) * height / 2;
//        AffineTransform tx = new AffineTransform();
//        tx.rotate(angle);
//        Rectangle shape = new Rectangle((int)x1, (int)y1, (int)width, (int)height);
//        g2.draw(shape);
        g.setColor(Color.black);
        g.fillRect((int) (x - width / 2), (int) (y - height / 2), (int) width, (int) height);

    }

}
