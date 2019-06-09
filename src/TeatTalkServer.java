import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class TeatTalkServer {
    public static void main (String agrs []) throws Exception{
        ServerSocket s = new ServerSocket(6699);//创建端口
        Socket ss = s.accept();//等待接收
            DataInputStream dis = new DataInputStream(ss.getInputStream());//创建输入流,拿到Client的文本
            for (int i = 0; i<20; i++) {
                System.out.println(dis.readUTF());//在输入台写出输入的文
                Scanner o = new Scanner(System.in);
                DataOutputStream dos = new DataOutputStream(ss.getOutputStream());//封装
                dos.writeUTF(o.next());//写输入台写的文本
            }
//        System.out.println("zhe出错了");
          dis.close();

    }
}
