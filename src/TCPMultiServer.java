import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPMultiServer {
    private static ServerSocket serverSocket = null;
    private static List<Socket> clientages = new ArrayList<Socket>();

    public static void main(String agrs[]) throws Exception {
        serverSocket = new ServerSocket(8877);
        System.out.println("启动监听线程");
        MonitorThread monitorThread = new MonitorThread();
        new Thread(monitorThread).start();
    }

     static class MonitorThread implements Runnable {
        public void run() {

            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientages.add(socket);//累加连接到server端的Client端的数量
                System.out.println("有Client连接");

                IoThread ioThread = new IoThread(socket);
                new Thread(ioThread).start();

            }
        }
    }

   static class IoThread implements Runnable {
        private Socket socket = null;

        public IoThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {

            DataInputStream dis = null;

            try {
                dis = new DataInputStream(socket.getInputStream());
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
                if (data == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                System.out.println(data);
                for (int i = 0; i < clientages.size(); i++) {
                    Socket socket1 = clientages.get(i);
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
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                }
            }
        }
    }
}