import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class TeatTextField {
    public static void main(String[] args) {
        TeatTF teatTF = new TeatTF();
        teatTF.setBounds(300,300,500,100);
    }
}
class TeatTF extends Frame {
    TeatTF(){
        TextField textField = new TextField();//创建一个输入框
        add(textField);//将输入框放到布局管理器内
        textField.addActionListener(new A());//监听输入框
        textField.setEchoChar('*');
//        textField.setBounds(400,500,200,200);
//       pack();
        setVisible(true);
    }
}
class A implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField textField = (TextField)e.getSource();
        System.out.println(textField.getText());//拿到输入框内的内容
        textField.setText("");//将输入框内容设为空
    }
}