import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    boolean started = false;
    ServerSocket ss = null;

    DataInputStream dis = null;
    public static List<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) {

        new ChatServer().start();

    }
        public void start(){

            try {
                ss = new ServerSocket(7875);
                started = true;
            }catch ( BindException b) {
                System.out.println("有客户端连接");
                System.out.println("请关闭相关程序，并重新启动服务器");
                System.exit(0);
            }catch (IOException e) {
                e.printStackTrace();
            }
            try{

                while (started) {
                    Socket s = ss.accept();
                    Client c = new Client(s);
                    System.out.println("有一个客户端连接");
                    //启动线程
                    new Thread(c).start();
                    clients.add(c);
                }
            } catch(IOException e){
                e.printStackTrace();
            }finally {//最后关闭连接
                try {
                    ss.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        class Client  implements Runnable {

           private Socket s;
           private  boolean bConnected = false;
           private  DataInputStream dis = null;
           private DataOutputStream dos = null;
            Client (Socket s ) {
               this.s = s;
                try {
                    dis = new DataInputStream(s.getInputStream());
                    dos = new DataOutputStream(s.getOutputStream());
                    bConnected = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void send (String str){
                try {
                    dos.writeUTF(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void run() {
                    try {
                    while (bConnected) {
                      String str = dis.readUTF();
                      System.out.println(str);
                      for ( int i = 0 ; i <clients.size(); i++){
                          Client c = clients.get(i);
                          c.send(str);
                      }
                      }

                    } catch (EOFException e) {
                        System.out.println("客户端已关闭");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            if (dis != null); dis.close();
                            if (dos != null); dos.close();
                            if (s != null); s.close();
                        }catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
            }
        }
}
