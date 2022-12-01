import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car(200, 200, 0, 0, 50, 50, 0);
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        Billboard board = new Billboard(car);
        frame.add(board);
        frame.setVisible(true);
        while (true){
            frame.repaint();
            car.setAngle(car.getAngle() + 0.000000001);
//            Thread.sleep(100);
        }


    }

}
