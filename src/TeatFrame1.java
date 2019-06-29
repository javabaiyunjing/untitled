import java.awt.*;

public class TeatFrame1 {

    public static void main(String[] args) {
        Fream1 frame1 = new Fream1(100,100,200,200,Color.red);
        Fream1 frame2= new Fream1(300,100,200,200,Color.blue);
        Fream1 frame3 = new Fream1(100,300,200,200,Color.black);
        Fream1 frame4 = new Fream1(300,300,200,200,Color.white);
    }
}
class Fream1 extends Frame{
    static int name = 1;
    Fream1 (int x,int y,int r,int a,Color color){
        super("www.xiaobaizuishuai.cn"+name++);
        setBounds(x,y,r,a);
        setBackground(color);
        setVisible(true);
    }

}