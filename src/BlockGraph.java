import java.util.ArrayList;
import java.util.List;

public class BlockGraph {
    ArrayList<ArrayList<Double>> matrix;
    ArrayList<ArrayList<Double>> points;
    ArrayList<Block> blocks;

    public BlockGraph(ArrayList<Block> blocks) {
        this.blocks = blocks;
        points = new ArrayList<ArrayList<Double>>();
        for (Block block : blocks) {
            for (Path path : block.paths) {
                ArrayList<Double> start_point = new ArrayList<>(List.of(path.getXs().get(0) + block.x, path.getYs().get(0) + block.y));
                ArrayList<Double> finish_point = new ArrayList<>(List.of(path.getXs().get(path.n - 1) + block.x, path.getYs().get(path.n - 1) + block.y));
                if (!points.contains(start_point)) {
                    points.add(start_point);
                }
                if (!points.contains(finish_point)) {
                    points.add(finish_point);
                }
            }
        }
        this.matrix = buildMatrix();
        System.out.println(matrix);
    }

    public ArrayList<ArrayList<Double>> buildMatrix() {
        int n = points.size();
        ArrayList<ArrayList<Double>> m = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < n; ++i) {
            ArrayList<Double> a = new ArrayList<Double>();
            for (int j = 0; j < n; ++j) {
                a.add(0.0);
            }
            m.add(a);
        }
        for (Block block : blocks) {
            for (Path path : block.paths) {
                double x1 = path.getXs().get(0);
                double y1 = path.getYs().get(0);
                double x2 = path.getXs().get(path.n - 1);
                double y2 = path.getYs().get(path.n - 1);
                ArrayList<Double> start_point = new ArrayList<>(List.of(path.getXs().get(0) + block.x, path.getYs().get(0) + block.y));
                ArrayList<Double> finish_point = new ArrayList<>(List.of(path.getXs().get(path.n - 1) + block.x, path.getYs().get(path.n - 1) + block.y));
                int i = points.indexOf(start_point);
                int j = points.indexOf(finish_point);
                double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                m.get(i).set(j, distance);
            }
        }
        return m;
    }

    public ArrayList<Integer> shortestPath(int i, int j){
        double inf = 9000000;
        ArrayList<Double> d = new ArrayList<Double>();
        ArrayList<ArrayList<Integer>> p = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int k = 0; k < points.size(); k++){
            d.add(0.0);
            if (k != i){
                d.set(k, inf);
                B.add(k);
            }
            else{
                d.set(k, 0.0);
                A.add(i);
            }
        }
        while (B.size() > 0){
            int V = 0;
            double d_v = inf + 1;
            for (int v : B){
                if (d.get(v) < d_v){
                    V = v;
                    d_v = d.get(v);
                }
            }
            for (int U = 0; U < points.size(); U++){
                double a = matrix.get(V).get(U);
                if (a > 0){

                    d.set(U, Math.min(d.get(U), d.get(V) + matrix.get(V).get(U)));
                }
            }
            A.add(V);
            B.remove(V);
        }
    }

}
