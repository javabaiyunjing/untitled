import java.net.*;
public class UDPClient {
    public static void main ( String agrs [])throws Exception{
        byte buf[] = (new String("555").getBytes());
        DatagramPacket dp = new DatagramPacket( buf,buf.length,
                new InetSocketAddress("127.0.0.1",5788));
        DatagramSocket ds = new DatagramSocket(9999);
        ds.send(dp);
        ds.close();
    }
}
