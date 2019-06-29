import java.awt.*;

public class TeatMultiPanel {
    public static void main(String[] args) {
        new Multi("SSSFSF",300,300,400,300);
    }
}
class Multi extends Frame{
    private Panel p1,p2,p3,p4;
    Multi(String s,int q ,int w,int e,int r){
          super(s);
        setLayout(null);
        p1 = new Panel(null);
        p2 = new Panel(null);
        p3 = new Panel(null);
        p4 = new Panel(null);
        p1.setBounds(0,0,e/2,r/2);
        p2.setBounds(0,w/2,e/2,r/2);
        p3.setBounds(q/2,0,e/2,r/2);
        p4.setBounds(q/2,w/2,e/2,r/2);
        p1.setBackground(Color.red);
        p2.setBackground(Color.green);
        p3.setBackground(Color.orange);
        p4.setBackground(Color.blue);
        add(p1); add(p2);add(p3); add(p4);
        setBounds(q,w,e,r);
        setVisible(true);
    }
}
