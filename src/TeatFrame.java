import java.awt.*;

public class TeatFrame {
    public static void main (String agrs[]) {
        Frame f = new Frame("大河向东流啊，天上的星星参北斗啊");
        FlowLayout o = new FlowLayout(FlowLayout.CENTER,20,30);
        f.setLayout(o);
        Button button = new Button("OK");
        Button button1 = new Button("NO");
//        f.setLayout(new FlowLayout(FlowLayout.RIGHT));
        f.add(button);
        f.add(button1);
        f.setSize(555,555);
        f.setBackground(Color.blue);
        f.setVisible(true);
    }
}



