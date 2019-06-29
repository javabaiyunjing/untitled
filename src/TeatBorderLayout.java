import java.awt.*;

public class TeatBorderLayout {
    public static void main(String[] args) {
        Frame f = new Frame("www.bai.com");
        Button button = new Button("west");
        Button button1 = new Button("east");
        Button button2 = new Button("south");
        Button button3 = new Button("north");
        Button button4 = new Button("ceter");
//      Button button5 = new Button("center");
        Panel p = new Panel();
        
        f.add(button, BorderLayout.WEST);
        f.add(button1,BorderLayout.EAST);
        f.add(button2,BorderLayout.SOUTH);
        f.add(button3,BorderLayout.NORTH);
        f.add(button4,BorderLayout.CENTER);
//        f.add(button5,BorderLayout.CENTER);
//        f.setBackground(Color.YELLOW);
        f.pack();
        f.setSize(400,400);
        f.setVisible(true);
    }
}
