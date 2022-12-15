import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ULBlock extends Block {

    ULBlock(double x, double y, double width, double height) {
        super(new Path(new ArrayList<>(List.of(width / 2, width / 2, 0.0)), new ArrayList<>(List.of(0.0, height / 2, height / 2)), Color.blue), x, y, width, height);
    }
}
