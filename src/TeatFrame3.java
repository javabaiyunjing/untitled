import java.awt.*;

public class TeatFrame3 {
    public static void main(String[] args) {
        Page p = new Page(400,300,400,400, Color.BLUE);
    }
}
class Page extends Frame {
    private  Panel p1;
    Page(int x, int y, int w, int h,Color c){
        super("www.bai.con");
        setLayout(null);
        setBounds(x, y, w, h);
        setBackground(c);
        p1 = new Panel(null);
        p1.setBounds(w/4,h/4,w/2,h/2);
        setBackground(Color.YELLOW);
        add(p1);
        setVisible(true);
    }

}

