import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeatActionEvent {
    public static void main(String[] args) {
        Frame f = new Frame("www.xin.com");
        Button b = new Button("yes");
        Button b1 = new Button("no");
//        TextField field = new TextField();
        Monitor m = new Monitor();
        b.addActionListener(m);
        b1.addActionListener(m);
        b.setActionCommand("打开程序");
//        f.add(field);
        f.add(b,BorderLayout.CENTER);
        f.add(b1,BorderLayout.SOUTH);
//        f.pack();
        f.setBounds(100,200,300,400);
        f.setVisible(true);
    }
}
class Monitor implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {//事件相关的信息会封装在ActionEvent e 内

            System.out.println("准备关闭"+e.getActionCommand());

    }
}

