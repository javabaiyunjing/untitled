import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatWindowClient {
    public static Socket cllient = null;
    private static Object Text2Frame;
    public static String da = null;
    public static void main(String[] args) throws  Exception {

        cllient = new Socket("127.0.0.1", 6899);

        ChatWindowContext.getInstance1().setContext("socket", cllient);

//        ThrandIOO thrandIOO = new ThrandIOO(cllient);
//        new Thread(thrandIOO).start();
        ThreadIo2 threadIo2 = new ThreadIo2(cllient);
        new Thread(threadIo2).start();

       initText2Frame();
    }

    public static void initText2Frame() {
        Text2Frame  text = new Text2Frame();
        ChatWindowContext.getInstance1().setContext("Text2Frame",Text2Frame);

    }
  static class ThreadIo2  implements Runnable{
        private Socket socket;

      ThreadIo2(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
           ChatWindowContext chatWindowContext = (ChatWindowContext) ChatWindowContext.getInstance1().getContext("Socket");
           ChatWindowContext text = (ChatWindowContext)ChatWindowContext.getInstance1().getContext("Text2Frame");
            DataInputStream dis = null;

            try {
                dis = new DataInputStream(this.socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    da = dis.readUTF();
                } catch (IOException e) {

                    e.printStackTrace();
                }
//                JTextField jt1 = (JTextField) ChatWindowContext.getInstance1().getContext("JTextField");
                JTextArea  jt2  = (JTextArea) ChatWindowContext.getInstance1().getContext("JTextArea");
//                jt1.getText();
                jt2.append(da);
                System.out.println(da);

             }
        }
    }
}
