import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LDBlock extends Block{
    double x;
    double y;
    double width;
    double height;
    LDBlock(double x, double y, double width, double height){
        super(new Path(new ArrayList<>(List.of(0.0, width / 2, width / 2)), new ArrayList<>(List.of(height / 2, height / 2, height)), Color.blue), x, y, width, height);
    }
}
