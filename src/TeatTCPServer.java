import java.io.*;
import java.net.*;
public class  TeatTCPServer{
    public static void   main (String agrs[]) throws Exception{
        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            Socket s = ss.accept();
            DataInputStream dis =  new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());
            while( true) {
                OutputStream os = s.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF("Server ：加油");
                s.close();
                dis.close();
                os.close();
                dos.close();
                dos.flush();
                ss.close();
            }
        }
    }
}
