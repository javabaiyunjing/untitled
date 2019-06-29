import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TeatMSocket1 {
    public static ServerSocket serverSocket = null;
    public static List<Socket> clientages1 = new ArrayList<Socket>();
    public static void main(String[] args) throws  Exception{
        serverSocket = new ServerSocket(9876);
        System.out.println("创建连接");

        JianTingThread jianTingThread = new JianTingThread();
        new Thread(jianTingThread).start();

    }
    static class JianTingThread implements  Runnable {
         public void run () {
             Socket socket = null;
             while (true) {
                 try {
                     socket = serverSocket.accept();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 clientages1.add(socket);
                 System.out.println("已连接到Client");
                 IoThread2 ioThread2 = new IoThread2(socket);
                 new Thread(ioThread2).start();
             }
         }

    }
    static class IoThread2 implements  Runnable{
        private Socket socket = null;
        public IoThread2 (Socket socket){
            this.socket = socket;
        }
        public void run (){
            while (true){
                DataInputStream dis = null;
                try {
                    dis = new DataInputStream(this.socket.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String data = null;
                try {
                    data = dis.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (data == null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                System.out.println(data);
                for (int i= 0 ; i<clientages1.size(); i++) {
                    Socket socket1 = clientages1.get(i);
                    if (socket1 == socket) {
                        continue;
                    }

                    DataOutputStream dos = null;
                    try {
                        dos = new DataOutputStream(socket1.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                        try {
                            dos.writeUTF(data);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            }

        }
    }
}
