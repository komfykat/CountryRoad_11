import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RLBlock extends Block{
    RLBlock(double x, double y, double width, double height){
        super(new Path(new ArrayList<>(List.of(width, 0.0)), new ArrayList<>(List.of(height / 2, height / 2)), Color.blue), x, y, width, height);
    }
}
