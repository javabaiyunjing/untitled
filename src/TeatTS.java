import java.net.*;
import java.io.*;
import java.util.Scanner;
public class TeatTS {
    public static void main ( String agrs []) throws Exception{
        ServerSocket s = new ServerSocket(6543);
        Socket ss = s.accept();
        DataInputStream dis = new DataInputStream(ss.getInputStream());
        for(int i= 0; i<5; i++){
            System.out.println(dis.readUTF());
            Scanner scan = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(ss.getOutputStream());
            dos.writeUTF(scan.next());
        }
        System.out.println("聊天结束");
        dis.close();
        ss.close();
    }
}
