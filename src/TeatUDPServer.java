import java.net.*;
import java.io.*;
public class TeatUDPServer {
    public static void main (String agrs[]) throws SocketException {
        byte buf [] = new byte[1024]; //设置数据包的大小
        DatagramPacket dp = new DatagramPacket(buf,buf.length);//接收数据包，将数据包放在buf内，能放1024个字节
        DatagramSocket ds = new DatagramSocket(5789);//监听5789的端口
        while (true){
        try {
        ds.receive(dp);//调用receive方法，等待接收数据，阻塞式
        } catch (IOException e) {
        e.printStackTrace();
        }
        System.out.println(new String(buf,0,dp.getLength()));
        }
    }
}
