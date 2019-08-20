import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class JieTU2 {
    public static void main(String[] args) throws AWTException, IOException {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Point point = new Point();
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(1300,700);
        BufferedImage bufferedReader = robot.createScreenCapture(rectangle);
        String formatName = "png";
        File f = new File("C:\\\\屏幕截图."+formatName );
        ImageIO.write(bufferedReader,formatName,f);

    }
}
