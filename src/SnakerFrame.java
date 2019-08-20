import javax.swing.*;
import java.awt.*;

public class SnakerFrame extends JFrame {

    public void paint (Graphics g) {
        super.paint(g);
//        System.out.println("draw graphics");
        Graphics2D g2d = (Graphics2D) g.create(); //创造一个绘图
        SnakeDrawThread snakeDrawThread = (SnakeDrawThread) SnakeContext.getInstance().getContext("snakeDrawThread");
        Snaker snaker = (Snaker)SnakeContext.getInstance().getContext("snaker");
        snakeDrawThread.setGraphics(g2d);
        snakeDrawThread.setSnaker(snaker);
    }

}
