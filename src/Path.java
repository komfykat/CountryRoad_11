import java.util.ArrayList;

public class Path {
    private ArrayList<Double> Xs;
    private ArrayList<Double> Ys;

    public Path(ArrayList<Double> xs, ArrayList<Double> ys) {
        Xs = xs;
        Ys = ys;
    }

    public ArrayList<Double> getXs() {
        return Xs;
    }

    public void setXs(ArrayList<Double> xs) {
        Xs = xs;
    }

    public ArrayList<Double> getYs() {
        return Ys;
    }

    public void setYs(ArrayList<Double> ys) {
        Ys = ys;
    }
}
