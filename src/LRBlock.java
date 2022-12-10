import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LRBlock extends Block{
    LRBlock(double x, double y, double width, double height){
        super(new Path(new ArrayList<>(List.of(0.0, 100.0)), new ArrayList<>(List.of(50.0, 50.0)), Color.blue), x, y, width, height);
    }

}
