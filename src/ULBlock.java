import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ULBlock extends Block {

    public ULBlock(double x, double y, double width, double height) {
        super(new ArrayList<>(List.of(new Path())), x, y, width, height);
        double x1 = 0.45 * width;
        double x2 = 0.55 * width;
        double y1 = 0.45 * height;
        double y2 = 0.55 * height;
        Path pathUL = new Path(new ArrayList<>(List.of(x1, x1, 0.0)), new ArrayList<>(List.of(0.0, y1, y1)));
        Path pathLU = new Path(new ArrayList<>(List.of(0.0, x2, x2)), new ArrayList<>(List.of(y2, y2, 0.0)));
        super.paths = new ArrayList<>(List.of(pathUL, pathLU));
        super.updatePaths();
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect((int) this.x, (int) this.y, (int) width, (int) height);
        int x0 = (int) (0.4 * width);
        int xt = (int) (0.6 * width);
        int y0 = (int) (0.4 * height);
        int yt = (int) (0.6 * height);
        g.drawLine((int) (x + x0) , (int) (y), (int) (x + x0), (int)(y + y0));
        g.drawLine((int) (x + x0) , (int) (y + y0), (int) (x), (int)(y + y0));
        g.drawLine((int) (x + xt) , (int) (y), (int)(x + xt), (int)(y + yt));
        g.drawLine((int) (x + xt) , (int) (y + yt), (int) (x), (int) (y + yt));
    }
}

