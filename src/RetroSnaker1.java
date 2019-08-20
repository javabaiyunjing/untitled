import java.awt.*;

public class RetroSnaker1 {

    public static final int WINDOWWIDTH = 650; //宽度640
    public static final int WINDOWHEIGHT = 500;//长度500
    public static final int GAMETABLEWIDTH = 400;

    public  static Button Start;//开始
    private static Button  Pause;//暂停
    private static Button  Stop;//结束
    private static Label  Score;//得分

    public static void main(String[] args) {
        Start = new Button("Start");
        Start.setBackground(Color.GREEN);
        Start.setBounds(500, 500, 60, 20);
//        add(Start);
        Pause = new Button("Pause");
        Pause.setBackground(Color.GREEN);
        Pause.setBounds(500, 550, 60, 20);
        Stop = new Button("Stop");
        Stop.setBackground(Color.GREEN);
        Stop.setBounds(500, 600, 60, 20);

    }
    //视图部分
    class View extends Frame {




    }
}

