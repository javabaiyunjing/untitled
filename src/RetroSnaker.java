import java.awt.*;

import static java.awt.BorderLayout.WEST;

public class RetroSnaker {
    public static void main(String[] args) {
     Frame4 f =  new Frame4(100,200,800,500,Color.WHITE);
     Timer timer = new Timer();
     new Thread(timer).start();
    }
}
class Frame4 extends Frame {
    private Panel p;
    Frame4 ( int x, int y, int w, int h ,Color c){
        super("贪吃蛇");
        setLayout(null);
        setBackground(c);
        setBounds(x,y,w,h);
        p  = new Panel(new BorderLayout());
        p.setBounds(0,0,600,500);
        p.setBackground(Color.blue);
        add(p,BorderLayout.SOUTH);
        setVisible(true);

    }
}
//计时器
class Timer implements  Runnable {

    public void run (){
        for(int i = 0; i < 10; i++){

            System.out.println(i);
        }
    }
}
