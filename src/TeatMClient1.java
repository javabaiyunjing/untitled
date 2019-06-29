import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TeatMClient1 {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 9876);
        System.out.println("已连接到Server");
        Scanner scan = new Scanner(System.in);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        TeatThread2 teatThread2 = new TeatThread2(client);
        new Thread(teatThread2).start();

        while (true) {
            dos.writeUTF(scan.next());

        }
    }
    public static class TeatThread2 implements  Runnable {
        public Socket socket =null;
        public TeatThread2(Socket socket){
            this.socket= socket;
        }
        public void run (){
            while (true){
                DataInputStream dis = null;
                try {
                    dis = new DataInputStream(socket.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String data = null ;
                try {
                  data =   dis.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(data );
            }
        }
    }
}
