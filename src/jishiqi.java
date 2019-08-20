import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
public class jishiqi extends JFrame {
    final TextField txt = new TextField(10);
    JLabel lbl = new JLabel();
    // JLabel lb2 = new JLabel();
    Date now = new Date();
    public jishiqi() {
        now.setHours(0);
        now.setMinutes(0);
        now.setSeconds(0);
        final Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date now2 = new Date(now.getTime() + 1000);
                now = now2;
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                lbl.setText(formatter.format(now));
            }
        });
        Button b1 = new Button("kaishi");
        Button b2 = new Button("tingzhi");
        Button b3 = new Button("jilu");
        b3.setBounds(50, 50, 50, 50);
        b2.setBounds(40, 40, 40, 40);
        b1.setBounds(30, 30, 30, 30);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button b = (Button) e.getSource();
                b.setLabel("开始计时");
                timer.start();
                b.setBackground(Color.yellow);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button b = (Button) e.getSource();
                b.setLabel("停止计时");
                timer.stop();
                b.setBackground(Color.yellow);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// Button b = (Button) e.getSource();
                Date now3 = new Date(now.getTime() + 1000);
                now = now3;
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
// String s=(new
// SimpleDateFormat("yyyy-MM-dd")).format(Calendar.getInstance().getTime());
                String s = formatter.format(now).toString();
                txt.setText(s);
                Button b = (Button) e.getSource();
                b.setLabel("记录时间");
                b.setBackground(Color.yellow);
            }
        });
        this.setLayout(new FlowLayout());
        this.add(txt);
        this.add(b3);
        this.add(b2);
        this.add(b1);
        this.add(lbl);
        this.setSize(300, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        jishiqi t = new jishiqi();
    }
}

