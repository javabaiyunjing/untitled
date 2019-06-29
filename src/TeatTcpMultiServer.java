import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TeatTcpMultiServer {
    private static ServerSocket serverSocket = null;
    private static List<Socket> clientage1 = new ArrayList<Socket>();

    public static void main(String agrs[]) throws Exception {
        serverSocket = new ServerSocket(9999);
        System.out.println("创建监听线程");
        MonitorThread1 monitorThread = new MonitorThread1();
        new Thread(monitorThread).start();
    }
    static class MonitorThread1 implements Runnable {

            public void run() {
                while (true){
                    Socket socket = null;
                    try {
                        socket = serverSocket.accept();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    clientage1.add(socket);
                    System.out.println("连接到client端");
                    IoThread1 ioThread = new IoThread1(socket);
                    new Thread(ioThread).start();
                }
            }
        }
        static class IoThread1 implements Runnable {
            private Socket socket = null;

            public IoThread1(Socket socket) {
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
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    System.out.println("client说：" + data);


                    for (int i = 0; i < clientage1.size(); i++) {
                        Socket socket1 = clientage1.get(i);

                        if (socket1 == socket) {
                            continue;
                        }
                        System.out.println(i);
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
