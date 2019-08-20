import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeatTFmath {
    public static void main(String[] args) {
        TF tf = new TF();
        tf.setBounds(220,200,200,200);
        tf.launchFrame();

    }
}
class TF extends Frame {
    TextArea t ,t1, t2;
    public void launchFrame(){
        t = new TextArea();
        t1 = new TextArea();
        t2 = new TextArea( );
    Label l  = new Label("+");
    Button b = new Button("=");
    b.addActionListener(new Monotor());
    setLayout(new FlowLayout());
    add(t);
    add(l);
    add(t1);
    add(b);
    add(t2);
    pack();
    setVisible(true);
    }
    class Monotor implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int o = Integer.parseInt(t.getText());
            int o1 = Integer.parseInt(t1.getText());
            t2.setText(""+(o+o1));
        }
}
//class Monotor implements ActionListener {
    /*
        TF tf = null;
        public Monotor (TF  tf ){
            this.tf=tf;
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        int o = Integer.parseInt(tf.t.getText());
        int o1 = Integer.parseInt(tf.t1.getText());
        tf.t2.setText(""+(o+o1));
    }

     */
}