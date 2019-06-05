import java.net.*;
public class UDPServer {
    public static void main (String agrs [])throws  Exception{
        byte buf[] = new byte[1024];//声明一个buf[]数组，容量为1024个字节
        DatagramPacket dp = new DatagramPacket(buf,buf.length);//创建一个数据包，
        DatagramSocket ds = new DatagramSocket(5788);
        while(true) {
            ds.receive(dp);
            System.out.println(new String(buf,0,dp.getLength()));
        }

    }
}
