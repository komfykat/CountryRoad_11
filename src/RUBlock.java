import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RUBlock extends Block{
    public RUBlock(double x, double y, double width, double height) {
        super(new Path(new ArrayList<>(List.of(width, width / 2, width / 2)), new ArrayList<>(List.of(height / 2, height / 2, 0.0)), Color.blue), x, y, width, height);
    }
}
