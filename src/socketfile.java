import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class socketfile {
    public static void main (String agrs [])throws  Exception {
        ServerSocket s = new ServerSocket(6666);
        Socket ss = s.accept();
        File f = new File("C:/哇哈哈4.txt");
        OutputStream os = ss.getOutputStream();
        FileInputStream fis = new FileInputStream(f);
        byte buf [] = new byte[100];
        int i = 0 ;
        while ((i = fis.read(buf))!=-1){
            os.write(buf,0,i);
        }
        os.close();
        fis.close();

    }
}

