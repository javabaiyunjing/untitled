import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class TeatPaint {
    public static void main(String[] args) {
        new Paint1().launchFrame();
    }
}
class  Paint1 extends Frame {

    public void launchFrame (){
        setBounds(300,220,600,500);
        setVisible(true);
    }
    public void paint (Graphics g) {//自动调用画笔
        Color c = g.getColor();//拿到当前画笔的颜色
        g.setColor(Color.GREEN);//设置为绿色
        g.fillOval(200, 200, 20, 20);//设计一个圆形或椭圆
        g.setColor(Color.BLUE);//设置为绿色
        g.fillRect(220, 200, 20, 20);//设置一个方块
        g.setColor(Color.RED);
        g.fillRect(240, 200, 20, 20);
        g.setColor(Color.BLACK);//将颜色恢复初始颜色
        g.drawLine(200,220,260,220 );

    }
}
