import java.io.*;
import java.net.*;
public class Client {
    public static void main (String agrs []) throws Exception{
        Socket s = new Socket("192.168.1.108",5555);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("哇哈哈哈");
        dos.writeUTF("6666");
        dos.writeUTF("8888");
        while (true) {
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println(dis.readUTF());
        }
    }
}
