import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class JieTU1 {
    public static void main(String[] args) throws AWTException, IOException {
    //    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();//dimension 翻译尺寸，toolkit 翻译工具箱  ，拿到屏幕的尺寸，宽，高
//        Point point = new Point(100,50);//创建一个坐标点，默认值为x= 0.y=0
        Robot robot = new Robot();//控制鼠标和键盘的应用程序生成本机系统输入事件
        Rectangle rectangle =new Rectangle(10,50,1366-20,500);//设置 X，Y，宽，高，默认为0
        BufferedImage bufferedReader = robot.createScreenCapture(rectangle);//缓冲图像，先把图像完整装入内存，在缓冲区中绘制图像或图形，然后将缓冲区中绘制好的图像或图形一次性输出在屏幕上
        String formatName = "png";//设置图片格式名
        File file = new File("D:\\\\tupian55."+formatName);//设置图片名后加上格式名
       ImageIO.write(bufferedReader,formatName,file);//将图片写到指定位置
    }
}
