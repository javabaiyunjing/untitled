import java.io.*;
import java.net.Socket;
public class clientFile {
    public static void main (String agrs [] )throws Exception {
        //创建客户端，本地IP为127.0.0.1， 指定连接端口号6666
        Socket  s = new Socket("127.0.0.1",6666);
        //将本文件夹内文件内容输出
        File newf = new File("C:/哇哈哈4.txt");
        //创建输出流
        OutputStream os = s.getOutputStream();
        FileOutputStream fos = new FileOutputStream(newf);
        //将文件内容每次输出100个字节
        byte buf[] = new byte[100];

            fos.write(buf);
        File f = new File("C:/哇哈哈1.txt");
        //创建输入流

        FileInputStream fis = new FileInputStream(f);
        fis.close();
        fos.close();
    }
 }
