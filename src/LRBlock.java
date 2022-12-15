import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LRBlock extends Block{
    LRBlock(double x, double y, double width, double height){
        super(new Path(new ArrayList<>(List.of(0.0, width)), new ArrayList<>(List.of(height / 2, height / 2)), Color.blue), x, y, width, height);
    }

}
