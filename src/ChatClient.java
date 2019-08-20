import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient extends Frame {
    Socket s = null;
    private boolean bConnevted = false;
    TextField tftxt = new TextField();
    TextArea taContent = new TextArea();
    DataOutputStream dos = null;
    DataInputStream dis = null;

    public static void main(String[] args) {
        new ChatClient().LaunchFrame();

    }

    public void LaunchFrame() {

        setLocation(300, 100);
        this.setSize(500, 600);
        add(tftxt, BorderLayout.SOUTH);
        add(taContent, BorderLayout.NORTH);
        pack();
        //关闭窗口
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tftxt.addActionListener(new TFlistener() {
        });
        setVisible(true);
        connect();
        new Thread(new RecvThread()).start();
    }

    private void connect() {
        try {
            s = new Socket("127.0.0.1", 7875);
            System.out.println("已连接");
            dos = new DataOutputStream(s.getOutputStream());
            dis = new DataInputStream(s.getInputStream());
            bConnevted = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private class TFlistener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String str = tftxt.getText().trim();//trim 去掉两边空格
            try {
                dos.writeUTF(str);
                dos.flush();//强制将缓冲区内容发出
                System.out.println(str);

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    private class RecvThread implements Runnable {
        @Override
        public void run() {
            try {
                while (bConnevted) {
                    String str = dis.readUTF();
                    taContent.setText(taContent.getText() + "\r\n "+str);
                    tftxt.setText("");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
