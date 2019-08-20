import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Text2Frame {

    //    private Object ChatWindowClient;

    Text2Frame(){
//
        ChatWindowContext.getInstance1().getContext("Text2Frame");
        System.out.println("启动文本");
        JTextField jt1=new JTextField();//new一个文本框
        JTextArea jt2=new JTextArea(); //new一个文本区

        JScrollPane jsp=new JScrollPane(jt2);//new一个滚条
        String title = "社会大柏哥的聊天室";
        JFrame jf=new JFrame(title);
        Container container=jf.getContentPane();
        container.setBackground(Color.yellow); //容器的背景色
        jf.setVisible(true);//窗体可见
        jf.setSize(600, 400);//窗体大小
        jf.setLayout(new BorderLayout());//边界布局
        jf.add(BorderLayout.CENTER,jt2);//文本区边界中间放置
        jf.add(BorderLayout.SOUTH,jt1);//文本框边界底部放置
//        jf.add(lable);
        jsp.setSize(20,50);
        jt1.setBackground(Color.pink);
        jt2.setBackground(Color.WHITE);
        jt2.setEditable(false);//让文本框内不可修改

        jt1.addActionListener(new ActionListener() { //监听器
             public void actionPerformed(ActionEvent e) {
                 JButton btnSend = new JButton("send");
//                 btnSend.addActionListener(new MouseAdapter(){
//                     public void mouseClicked (MouseEvent e) {
////                         ChatWindowContext.getInstance1().send(jt1.getText());
//                     }
//                 });

                  String data = null;
                  data = jt1.getText();//得到jt1输入的文本
                  jt2.append("\r\n" + "白娘子说："+data);//每输入一次按回车自动换行
                  jt2.setLineWrap(true);//满一行后自动换行
                  jt1.setText("");//将文本框设置为空
                 ChatWindowContext.getInstance1().setContext("JTextField",jt1);
                 Socket socket = (Socket) ChatWindowContext.getInstance1().getContext("socket");

                 DataOutputStream dos = null;
                 try {
                     dos = new DataOutputStream(socket.getOutputStream());
                 } catch (IOException e1) {
                     e1.printStackTrace();
                 }
                 try {
                     dos.writeUTF(data);
                 } catch (IOException e2) {
                     e2.printStackTrace();
                 }
             }
        });
    }
}
