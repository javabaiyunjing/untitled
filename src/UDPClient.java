import java.net.*;
public class UDPClient {
    public static void main ( String agrs [])throws Exception{
        byte buf[] = (new String("551454145").getBytes());
        DatagramPacket dp = new DatagramPacket( buf,buf.length,
                new InetSocketAddress("127.0.0.1",5788));
       DatagramSocket ds = new DatagramSocket(9999);
        ds.send(dp);//将buf内的文本由本端口9999发送到5788端口
        ds.close();//关闭9999端口
    }
}
