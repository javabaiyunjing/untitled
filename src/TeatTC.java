import java.io.*;
import  java.net.*;
import  java.util.*;
public class TeatTC {
    public static void main ( String agrs[])throws  Exception{
        Socket s = new Socket("127.0.0.1",6543);
        Scanner scan = new Scanner(System.in);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        for ( int i = 0; i<5; i++) {
            dos.writeUTF(scan.next());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());
        }
        System.out.println("聊天结束");
        dos.close();
        s.close();
    }
}
