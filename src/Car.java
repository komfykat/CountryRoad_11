import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Car {
    private double x;
    private double y;
    public double BlockX;
    public double BlockY;
    public int number;
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
    public Color color;
    public ArrayList<Block> blocks;
    public ArrayList<Car> cars;
    public Spawner spawner;

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

    public Car(double v, double width, double height, Spawner spawner) {
        this.x = spawner.x;
        this.y = spawner.y;
        this.v = v;
        this.width = width;
        this.height = height;
        this.spawner = spawner;
    }

    public Car(double v, double width, double height) {
        this.v = v;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        if (block != null) {
            x = BlockX + block.x;
        }
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        if (block != null) {
            y = BlockY + block.y;
        }
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
                double nextX = path.getXs().get(PathPosition);
                double nextY = path.getYs().get(PathPosition);
//                System.out.println(nextX + " " + nextY);
                if (abs(BlockX - nextX) <= Constants.epsilon && abs(BlockY - nextY) <= Constants.epsilon && PathPosition < path.n) {
                    PathPosition++;
                }
                if (abs(BlockX - nextX) <= Constants.epsilon && abs(BlockY - nextY) <= Constants.epsilon && PathPosition == path.n) {
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
            boolean flag2 = findNextBlock();
            if (!flag2){
                this.stop();
            }
        }
    }
    public double distance(Car car){
        return Math.sqrt(Math.pow(x - car.x, 2) + Math.pow(y - car.y, 2));
    }
    public boolean intersect(Car car) {
            if (car.inMotion && !(car.vx == 0 && car.vy == 0)) {
                double carvx = car.vx;
                double carvy = car.vy;
                if (abs(carvx / vx - carvy / vy) <= Constants.epsilon) {
                    return this.distance(car) <= car.height * 4;
                } else {
                    Line2D a = new Line2D.Double(x, y, x + vx * Constants.check, y + vy * Constants.check);
                    Line2D b = new Line2D.Double(car.x, car.y, car.x + car.vx * Constants.check, car.y + car.vy * Constants.check);
                    return (a.intersectsLine(b));
                }
            } else {
                Line2D a = new Line2D.Double(x, y, x + vx * Constants.check, y + vy * Constants.check);
                Rectangle2D b = new Rectangle2D.Double(car.x - 5, car.y - 5, 10, 10);
                return (a.intersects(b));
            }
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

    public boolean findNextBlock() {
        for (Block block : blocks) {
            for (Path path : block.paths) {
                if (abs(path.getXs().get(0) + block.x - getX()) <= Constants.epsilon && abs(path.getYs().get(0) + block.y - getY()) <= Constants.epsilon) {
                    this.block = block;
                    this.path = path;
                    PathPosition = 0;
                    inPath = true;
                    BlockX = path.getXs().get(0);
                    BlockY = path.getYs().get(0);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ifBlock() {
        boolean foundBlock = false;
        for (Block block : blocks) {
            for (Path path : block.paths) {
                if (abs(path.getXs().get(0) + block.x - getX()) <= Constants.epsilon && abs(path.getYs().get(0) + block.y - getY()) <= Constants.epsilon) {
                    foundBlock = true;
                }
            }
        }
        return foundBlock;
    }


    public boolean check(Car car) {
            if (intersect(car)) {
               System.out.println("Intersects" + "" + cars.indexOf(this));
                if (!(car.inMotion)){
                    return true;
                }
                if (atRight(car)) {
                    System.out.println("atright" + "" + cars.indexOf(this));
                    System.out.println(car.inMotion);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
    }

    public Car copy() {
        return (new Car(v, width, height));
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect((int) (getX() - width / 2), (int) (getY() - height / 2), (int) width, (int) height);

    }


}
