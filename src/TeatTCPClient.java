import java.io.*;
import java.net.*;
public class TeatTCPClient {
    public static void main(String agrs []) throws  Exception{
        Socket s = new Socket("127.0.0.1",6688);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("我爱你中华");
        os.close();
        dos.close();
    }
}