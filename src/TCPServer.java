import  java.net.*;
import java.io.*;
public class TCPServer {
    public static void  main (String agrs []) throws Exception{
       ServerSocket ss = new ServerSocket(5555);//指定端口号，监听客户端的链接
        while (true) {
            Socket s = ss.accept();//accept 返回值为Socket，意为接收,阻塞式，死等接收
            DataInputStream dis = new DataInputStream(s.getInputStream());//拿到输出流的东西
            System.out.println(dis.readUTF());//读Client的一个字符串
            dis.close();//关闭
            s.close();//关闭

        }
    }
}









