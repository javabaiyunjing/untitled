import java.util.List;
import java.awt.*;

public class SnakeDrawThread implements Runnable {
    private Graphics graphics = null;// 绘图
    private Snaker snaker = null;
    private int fps = 30;//每秒的帧数

    public SnakeDrawThread(){ }
    public SnakeDrawThread( Graphics g) {
        this.graphics = g;
    }
    public SnakeDrawThread(Snaker snaker) {
        this.snaker =snaker;
    }
    public SnakeDrawThread(Snaker snaker,Graphics g ) {
        this.graphics =g;
        this.snaker = snaker;
    }
    @Override
    public void run() {

        while (true) {
            SnakeContext snakeContext = SnakeContext.getInstance();//如果有Snake 和graphics

            try {
                Thread.sleep((long) Math.floor(1000 / fps));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (graphics != null) {
                //去上下文取蛇的信息
                SnakerFrame snakerFrame = (SnakerFrame) snakeContext.getContext("snakerFrame");
                snakerFrame.paint(getGraphics());
            }
            if (snaker != null && graphics != null) {
                //设置当前颜色
                Color defaultColor = new Color(39, 45, 180);

                //去上下文去取食物信息
                Food food = (Food) SnakeContext.getInstance().getContext("food");
                if (food != null) { //设置食物的大小
                    graphics.setColor(Color.orange);
                    graphics.fillRect(
                            food.getX() * food.getW(),
                            food.getY() * food.getH()+20,
                                food.getW(),
                                food.getH());

                }
                List<SnakerBody> snakerBodyList = snaker.getsnakeBody();
                for (int i = 0; i < snakerBodyList.size(); i++) {
                    SnakerBody snakerItem = snakerBodyList.get(i);

                    int snakerH = snakerItem.getHeight();
                    int snakerW = snakerItem.getWidth();
                    int snakerX = snakerItem.getX();
                    int snakerY = snakerItem.getY();
                    if (i != 0) {
                        graphics.setColor(Color.MAGENTA);
                    } else {
                        graphics.setColor(Color.MAGENTA);
                    }
                    graphics.fillRect(//绘制矩形
                            snakerX * snakerW,
                            snakerY * snakerH + 22,
                            snakerW,
                            snakerH
                    );

                }

                graphics.setColor(defaultColor);
                graphics.drawString("fps" + fps, RetroSnaker.WindowWidth - 60, 40);
                graphics.setColor(defaultColor);
                graphics.drawString("长度：" + snakerBodyList.size(), RetroSnaker.WindowWidth - 60, 55);
            }

        }
    }
public Graphics getGraphics (){
    return graphics;
}
public SnakeDrawThread setGraphics(Graphics graphics){
        this.graphics = graphics;
        return this;
}
public Snaker getSnaker(){
        return snaker;
}
public SnakeDrawThread setSnaker (Snaker snaker){
        this.snaker = snaker;
        return this;
}
public int getFps(){
        return fps;
}
public SnakeDrawThread setFps ( int  fps) {
        this.fps = fps;
        return this;
}
}