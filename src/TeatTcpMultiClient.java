import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TeatTcpMultiClient {
    public static void main (String agrs[] )throws Exception{
        Socket client =new Socket("127.0.0.1",9999);
        System.out.println("已连接到Server");
        Scanner san = new Scanner(System.in);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        IOThread1 ioThread = new IOThread1(client);
        new Thread(ioThread).start();
        while (true) {
            dos.writeUTF(san.next());
        }
    }
     static class IOThread1 implements Runnable{
        private Socket socket =null;
        IOThread1 (Socket socket){
            this.socket= socket;
        }
        public void run() {
            DataInputStream dis = null;
            try {
                dis = new DataInputStream(this.socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String data = null;
            while (true) {
                try {
                    data = dis.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(data);
            }
        }
    }
}
