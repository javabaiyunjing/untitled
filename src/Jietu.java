import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Jietu {
    public static void main(String[] args) throws AWTException, IOException {

       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//拿到屏幕的尺寸，
        Point point= new Point(100, 50);//设置X，Y 轴度数
        Rectangle rectangle = new Rectangle(100, 50, 1366-100, 768 - 50);//创建一个矩形

        System.out.println(rectangle);
        Robot robot = new Robot();//创建一个机器人，
        BufferedImage bi = robot.createScreenCapture(rectangle);//缓冲图像，
        String formatName = "png";//设置截图图片的格式为PNG
        File file = new File("D:\\\\screen2." + formatName);//创建一个目录
        ImageIO.write(bi, formatName, file);//将缓冲区图像


    }

}
