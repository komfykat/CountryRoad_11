import java.util.ArrayList;

public class Despawner {
    public double x;
    public double y;
    public ArrayList<Car> cars;

    public Despawner(double x, double y, ArrayList<Car> cars) {
        this.x = x;
        this.y = y;
        this.cars = cars;
    }

    public ArrayList<Car> update(){
        cars.removeIf(car -> Math.pow(x - car.getX(), 2) + Math.pow(y - car.getY(), 2) <= Constants.epsilon * Constants.epsilon);
        return cars;
    }
}
