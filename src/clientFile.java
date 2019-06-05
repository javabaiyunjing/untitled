import java.io.*;
import java.net.Socket;
public class clientFile {
    public static void main (String agrs [] )throws Exception {
        Socket s = new Socket("127.0.0.1",6666);
        File f = new File("C:/哇哈哈6.txt");
        InputStream is = s.getInputStream();
        FileOutputStream fos = new FileOutputStream(f);
        byte buf [] = new byte[100];
        int i = 0;
        while ((i = is.read(buf))!=-1) {
            fos.write(buf, 0, i);
        }
        is.close();
        fos.close();

    }
 }
