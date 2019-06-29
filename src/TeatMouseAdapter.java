import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class TeatMouseAdapter {
    public static void main(String[] args) {
        new MyFrame("www.xin.cn");
    }

}
class MyFrame extends Frame {
    ArrayList p = null;
    MyFrame (String s ){
        super(s);
        p  = new ArrayList();//将数组列表 清空
        setLayout(null);
        setBounds(400,400,300,300);
        setBackground(new Color(204,204,255));
        setBackground(Color.orange);
        setVisible(true);
       addMouseListener(new Mouse1());
    }
    public void paint (Graphics g) {
        Iterator i = p.iterator();
        while (i.hasNext()) {//拿到ArrayList中的点都拿出来
            Point pp = (Point) i.next();
            g.setColor(Color.RED);
            g.fillOval(pp.x, pp.y, 10, 10);
        }
    }
    public void addPoint (Point pp){
        p.add(pp);//每次鼠标点击时，增加一个点
    }
}
class Mouse1 extends MouseAdapter {
    public void mousePressed(MouseEvent e){//监听鼠标按下去的事件
       MyFrame m = (MyFrame)e.getSource();//将事件源添加到MyFrame上面
        m.addPoint(new Point (e.getX(),e.getY()));// 拿到鼠标按下去得点的坐标，鼠标每点一下NEW一个点对象，调用point，
        m.repaint();//强制重画Frame

    }

}
