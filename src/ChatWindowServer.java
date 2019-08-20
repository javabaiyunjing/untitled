import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatWindowServer {
    public static ServerSocket serverSocket1 = null;
    public static List<Socket> socketsArray1 = new ArrayList<Socket>();

    public static void main(String[] args) throws Exception{

       serverSocket1 = new ServerSocket(6899);
       AThread aThread = new AThread();
       new Thread(aThread).start();

    }

    static class AThread implements Runnable {

        public void run() {
         Socket socket = null;
            while(true){
                try {
                    socket = serverSocket1.accept() ;
                 } catch (IOException e) {
                e.printStackTrace();
            }
             socketsArray1.add(socket);

             System.out.println("建立连接");
             IoThread ioThread = new IoThread(socket);
             new Thread (ioThread).start();

            }
        }
    }
    static class IoThread implements  Runnable {
        private Socket socket = null;
        private Object Socket;

        IoThread(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            //输入流
            DataInputStream dis = null;

            while (true){
                try {
                    dis = new DataInputStream(socket.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                 String data = null;
                while (true){
                    try {
                        data = dis.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (socket == null){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ChatWindowContext.getInstance1().getContext(data);
                    System.out.println("群聊共"+socketsArray1.size()+"人说："+data );

                    for ( int i =0; i <socketsArray1.size(); i++ ) {
                        Socket socketA = socketsArray1.get(i);
//                        if (socketA == socket) {
//                            continue;
//                        }
                        DataOutputStream dos = null;
                        try {
                            dos = new DataOutputStream(socketA.getOutputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            dos.writeUTF(data);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }




//                        JTextField jTextField = (JTextField) ChatWindowContext.getInstance1().getContext("JTextField");
//
////                        jTextField.addActionListener(new ActionListener() {
////                            @Override
////                            public void actionPerformed(ActionEvent e) {
//                        jTextField.getText();
//                        JTextArea j = new JTextArea();
//                        j.append(jTextField.getText());
//                                    jTextField.setText("一会再聊" );
//                                }
//                            });
                        }

                }
            }
        }
    }


}