import java.io.IOException;
import java.net.*;
public class TeatUDPClient {
    public static void  main (String agrs []) throws SocketException {
        byte[] buf = (new String("啦啦啦啦啦")).getBytes();//数据包
        DatagramPacket dp = new DatagramPacket(buf,buf.length,//将数据包打包成字符串
                new InetSocketAddress("127.0.0.1",5789));//将字符串由自身的IP地址127.0.0.1发送到服务器的端口5789
        DatagramSocket ds = new DatagramSocket(9999);
        try {
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds.close();
    }
}
