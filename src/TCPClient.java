import java.net.*;
import java.io.*;
public class TCPClient {
    public static void main (String agrs []) throws Exception{
        Socket s = new Socket("127.0.0.1", 6666);//127.0.0.1为本地IP， 后面指定要连接的端口号
        OutputStream  os  = s.getOutputStream();//返回Servlet引擎创建的字节输出流对象
        DataOutputStream dos  = new DataOutputStream(os); //数据输出流
        dos.writeUTF("hello server");//以 UTF-8 的形式写省空间
        dos.flush();//清空缓冲区数据
        dos.close();//关闭
        s.close();//关闭
    }
}
