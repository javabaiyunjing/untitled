import java.io.*;
import java.net.*;
public class  TeatTCPServer{
    public static void   main (String agrs[]) throws Exception{
        ServerSocket s = new ServerSocket(6688);
        Socket ss = new Socket();
        while (true) {
            InputStream is =ss.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println(dis.readUTF());
            is.close();
            dis.close();
        }
    }
}
