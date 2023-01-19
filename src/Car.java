import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Car {
    private double x;
    private double y;
    public double BlockX;
    public double BlockY;
    private double v;
    public double vx;
    public double vy;
    private double angle;
    private double width;
    private double height;
    public Path path;
    public Block block;
    public int PathPosition = 0;
    public boolean inMotion = true;
    public boolean inPath = true;
    public double stopTime = 0;
    public Color color;
    public ArrayList<Block> blocks;
    public ArrayList<Car> cars;

    public Car(double blockX, double blockY, double v, double width, double height, Path path, Block block, ArrayList<Block> blocks) {
        BlockX = blockX;
        BlockY = blockY;
        this.v = v;
        this.width = width;
        this.height = height;
        this.path = path;
        this.block = block;
        this.x = BlockX + this.block.getX();
        this.y = BlockY + this.block.getY();
        this.blocks = blocks;
    }

    public double getX() {
        x = BlockX + block.x;
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        y = BlockY + block.y;
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
            boolean flag = false;
            for (Car car : cars) {
                if (!car.equals(this)) {
                    if (check(car)) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                this.stop();
            } else {
                this.move();
            }
            if (inMotion) {
                stopTime = 0;
                double nextX = path.getXs().get(PathPosition);
                double nextY = path.getYs().get(PathPosition);
//                System.out.println(nextX + " " + nextY);
                if (Math.abs(BlockX - nextX) <= Constants.epsilon && Math.abs(BlockY - nextY) <= Constants.epsilon && PathPosition < path.n) {
                    PathPosition++;
                }
                if (Math.abs(BlockX - nextX) <= Constants.epsilon && Math.abs(BlockY - nextY) <= Constants.epsilon && PathPosition == path.n) {
                    inPath = false;
                } else {
                    nextX = path.getXs().get(PathPosition);
                    nextY = path.getYs().get(PathPosition);
                }
                double vx = v * (nextX - BlockX) / Math.sqrt(Math.pow(nextX - BlockX, 2) + Math.pow(nextY - BlockY, 2));
                double vy = v * (nextY - BlockY) / Math.sqrt(Math.pow(nextX - BlockX, 2) + Math.pow(nextY - BlockY, 2));
                this.vx = vx;
                this.vy = vy;
//                System.out.println(vx + " " + vy);

                BlockX += vx * Constants.tick;
                BlockY += vy * Constants.tick;
//                System.out.println(BlockX + " " + BlockY + "\n");
            }

        } else {
            findNextBlock();
            this.stop();
        }
    }

    public boolean intersect(Car car) {
        double carvx = 0;
        double carvy = 0;
        if (car.inMotion) {
            carvx = car.vx;
            carvy = car.vy;
        }
        if ( x > 170){
//            System.out.println("hop");
        }
        Rectangle2D a = new Rectangle2D.Double(x - Constants.epsilon2, y - Constants.epsilon2, Constants.check * vx + Constants.epsilon2, Constants.check * vy + Constants.epsilon2);
        Rectangle2D b = new Rectangle2D.Double(car.x - Constants.epsilon2, car.y - Constants.epsilon2, Constants.check * carvx + Constants.epsilon2, Constants.check * carvy + Constants.epsilon2);
//        System.out.println(a);
//        System.out.println(b);
        return (a.intersects(b));
    }

    public boolean atRight(Car car) {
        Vector3D a = new Vector3D(Constants.check * vx, Constants.check * vy, 0);
        Vector3D b = new Vector3D(Constants.check * car.vx, Constants.check * car.vy, 0);
        return (a.right(b));
    }


    public void stop() {
        inMotion = false;
    }

    public void move() {
        inMotion = true;
    }

    public void findNextBlock() {
        for (Block block : blocks) {
            for (Path path : block.paths) {
                if (Math.abs(path.getXs().get(0) + block.x - getX()) <= Constants.epsilon && Math.abs(path.getYs().get(0) + block.y - getY()) <= Constants.epsilon) {
                    this.block = block;
                    this.path = path;
                    PathPosition = 0;
                    inPath = true;
                    BlockX = path.getXs().get(0);
                    BlockY = path.getYs().get(0);
                }
            }
        }
    }


    public boolean check(Car car) {
        if (block == car.block) {
            if (intersect(car)) {
                System.out.println("Intersects");
                if (atRight(car)) {
                    System.out.println("atright");
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect((int) (getX() - width / 2), (int) (getY() - height / 2), (int) width, (int) height);

    }

}
