import java.awt.*;
import java.util.ArrayList;

public class Path {
    private ArrayList<Double> Xs;
    private ArrayList<Double> Ys;
    public int n;
    public Path(ArrayList<Double> xs, ArrayList<Double> ys) {
        Xs = xs;
        Ys = ys;
        n = Xs.size();
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
    public void paint(Graphics g){
        for (int i = 0; i < n; ++i){
            g.setColor(Color.red);
            g.fillRect(Xs.get(i).intValue() - 7, Ys.get(i).intValue() - 7, 14, 14);
        }
    }
}
