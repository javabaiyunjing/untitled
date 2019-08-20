import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {

    public void paint (Graphics g){
        System.out.println("绘制着呢昂");
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g.create();
        ChatWindowDraw chatWindowDraw = (ChatWindowDraw) ChatWindowContext.getInstance1().getContext("chat");
       chatWindowDraw.setGraphics1(graphics2D);
    }
}
