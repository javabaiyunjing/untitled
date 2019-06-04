import java.net.*;
import java.io.*;
public class TalkServer {
    public static  void main(String agrs[]) {
        try {
            ServerSocket ss = null;
            try {
                ss = new ServerSocket(6888);
            } catch (Exception e) {
                System.out.println("No more wiretaps，不能窃听了"+ e);
            }
            Socket s = null;
            try {
                s = ss.accept();
            } catch (Exception e) {
                System.out.println("error"+ e);
            }
            String line;
            BufferedReader is= new BufferedReader(//缓冲读取字符
                    new InputStreamReader(s.getInputStream()));//读取client 传输的信息
            PrintWriter os = new PrintWriter(s.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client:" + sin.readLine());
            line = sin.readLine();
            while (!line.equals("bye")) {
                os.println(line);
                os.flush();
                System.out.println("Server:" + line);
                System.out.println("Client:" + is.readLine());
                line = sin.readLine();
            }
            os.close();
            ss.close();
            s.close();
        }catch (Exception e){System.out.println("Error"+ e);}
    }
    }


