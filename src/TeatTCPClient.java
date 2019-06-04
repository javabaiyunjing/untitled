import java.io.*;
import java.net.*;
public class TeatTCPClient {
    public static void main(String agrs []) throws  Exception{
        Socket s = new Socket("127.0.0.1",6666);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("Client :加油");
        DataInputStream dis =  new DataInputStream(s.getInputStream());
        System.out.println(dis.readUTF());
        s.close();
        dos.flush();
        dos.close();
        dis.close();
    }
}