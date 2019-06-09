import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
public class TeatTalkClient {
    public static void main (String agrs []) throws Exception {
        Socket s = new Socket("127.0.0.1", 6699);//连接端口
        Scanner ss = new Scanner(System.in);//接收键盘输入的文本
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());//创建输出流
        for(int i= 0 ; i<20; i++) {
            dos.writeUTF(ss.next());//写出键盘的文本 }
//        System.out.println("z出错了");
        DataInputStream dis = new DataInputStream(s.getInputStream());//封装
            System.out.println(dis.readUTF());
//            System.out.println("dingle");
        }
        dos.close();

    }
}
