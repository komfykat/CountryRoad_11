import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DRBlock extends Block{
    public DRBlock(double x, double y, double width, double height) {
        super(new Path(new ArrayList<>(List.of(width / 2, width / 2, width)), new ArrayList<>(List.of(height, height / 2, height / 2)), Color.blue), x, y, width, height);
    }
}
