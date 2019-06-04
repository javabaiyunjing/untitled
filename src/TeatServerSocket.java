import  java.net.*;
import java.io.*;
public class TeatServerSocket {
 public static void main (String agrs []) throws Exception{
     ServerSocket s = new ServerSocket(5555);
     Socket ss = s.accept();
     DataInputStream dis = new DataInputStream(ss.getInputStream());
    System.out.println(dis.readUTF());

 }
}
