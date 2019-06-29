import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPMultiClient {
    public static void main(String agrs[]) throws Exception {
        Socket client = new Socket("127.0.0.1", 8877);
        System.out.println("已连接到Sercer端");
        IoThread ioThread = new IoThread(client);
        new Thread(ioThread).start();
        Scanner scan = new Scanner(System.in);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        while (true) {
            dos.writeUTF(scan.next());
        }
    }
    public static class IoThread implements Runnable {
        private Socket socket = null;

        IoThread(Socket socket) {
            this.socket = socket;
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
