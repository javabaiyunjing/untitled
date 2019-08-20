import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class TeatwindowAdapter {
    public static void main(String[] args) {
        new MyFrame2("www.xin.cn");
    }
}
class MyFrame2 extends Frame {
    MyFrame2 (String s){
        super(s);
        setLayout(null);
        setBackground(new Color(204,204,255));
        setBounds(300,300,200,200);
        setVisible(true);
       addWindowListener(new MyWindow());
    }
    class MyWindow extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            setVisible(false);//关闭图像
            System.exit(0);
        }
    }
}