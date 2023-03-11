import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HBlock extends Block{

    public HBlock(double x, double y, double width, double height) {
        super(new ArrayList<>(List.of(new Path())), x, y, width, height);
        double y1 = 45;
        double y2 = 55;
        Path pathLR = new Path(new ArrayList<>(List.of(0.0, width)), new ArrayList<>(List.of(y2, y2)));
        Path pathRL = new Path(new ArrayList<>(List.of(width, 0.0)), new ArrayList<>(List.of(y1, y1)));
        super.paths = new ArrayList<>(List.of(pathLR, pathRL));
        super.updatePaths();

    }

    @Override
    public void paint(Graphics g) {
        g.drawRect((int) this.x, (int) this.y, (int) width, (int)height);
        double y0 = 40 + y;
        double yt = 60 + y;
        g.drawLine((int) x, (int)(y0), (int)(x + width), (int)(y0));
        g.drawLine((int) x, (int)(yt), (int)(x + width), (int)(yt));
    }
}
