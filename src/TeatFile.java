import java.io.*;
public class TeatFile {
    public static void main (String agrs []) throws Exception{
        File s = new File("C:/哇哈哈.txt" );//准备将"C:/哇哈哈.txt内的内容复制到另一个文本内
        File news = new File("C:/哇哈哈11.txt" );//此文本接受"C:/哇哈哈.txt里的内容
        FileInputStream fis = new FileInputStream(s);//建立输入流
        FileOutputStream fos = new FileOutputStream(news);//建立输出流
        byte buf [] = new byte[100];//文件以每次100个字节传输
        int i = 0 ;
        while ((i = fis.read(buf))!= -1){//读取完成后
            fos.write(buf,0,i);//写出接收到的内容到C:/哇哈哈11.txt
            fos.flush();//清除数据
        }
        fos.close();//关闭输出流
        fis.close();//关闭输入流
    }
}
