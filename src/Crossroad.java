import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Crossroad extends Block{

    public Crossroad(double x, double y, double width, double height) {
        Path path1 = new Path(new ArrayList<>(List.of(0.0, width)), new ArrayList<>(List.of(0.55 * height, 0.55 * height)), Color.blue);
        ArrayList<Path> paths = new ArrayList<>(List.of(path1));
        super(paths, x, y, width, height);
    }
}
