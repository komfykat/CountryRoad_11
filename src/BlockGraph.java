import java.util.ArrayList;
import java.util.List;

public class BlockGraph {
    ArrayList<ArrayList<ArrayList<Double>>> matrix;
    ArrayList<ArrayList<Double>> points;
    ArrayList<Block> blocks;

    public BlockGraph(ArrayList<Block> blocks) {
        this.blocks = blocks;
        for (Block block : blocks) {
            for (Path path : block.paths) {
                ArrayList<Double> start_point = new ArrayList<>(List.of(path.getXs().get(0), path.getYs().get(0)));
                ArrayList<Double> finish_point = new ArrayList<>(List.of(path.getXs().get(path.n - 1), path.getYs().get(path.n - 1)));
                if (!points.contains(start_point)){
                    points.add(start_point);
                }
                if (!points.contains(finish_point)){
                    points.add(finish_point);
                }
            }
        }
    }

    public ArrayList<Path> findNextPath(Path path) {
        ArrayList<Path> ans = new ArrayList<Path>();
        for (Block block : blocks) {
            for (Path path_i : block.paths) {
                if (path_i.getXs().get(0) == path.getXs().get(path.n - 1) && path_i.getYs().get(0) == path.getYs().get(path.n - 1)) {
                    ans.add(path_i);
                }
            }
        }
        return ans;
    }
}
