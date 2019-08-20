import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class RetroSnaker  {

    public static final int WindowWidth= 500;//宽度500
    public static final int WindowHetght = 500;//长度500
//    public static final int SnakerWidth =25;
//    public static final int SnakerHetghe =25;
    private static Object SnakerFrame;
//    public static final int SnakeBodys = 0;
//    public static final int GametableWidth= 400;//游戏页面大小
//    int len = 6;//初始化蛇身长度
//    int FoolX[] = new int [640];//定义食物存放在数组内，方便随机数
//    int FoolY[] = new int [400];
//    private int direction  ;//定义方向
//    public static final int SOUTH = 0, NORTH = 1, EAST = 2, WEST = 3;

    public static void main(String[] args) {
//        SnakerBodys s  = new SnakerBodys();
//        ArrayList<Integer> sbs =new ArrayList<Integer>();
//       Timer timer= new Timer("社会大柏哥的贪吃蛇");
//       timer.launchFrame();

       //初始化
        initSnaker();

        initFood();

        initSnakerFrame();

        //起线程
        runThread();

    }

    public static void initSnakerFrame () {
        SnakerFrame snakerFrame = new SnakerFrame();

        SnakeContext.getInstance().setContext("snakerFrame",snakerFrame);
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth  = (int) screenDimension.getWidth();
        int screenHeight = (int) screenDimension.getHeight();
        int windowWidth  = WindowWidth;
        int windowHeight = WindowHetght+22+25;

        int windowPositionX = (int) Math.floor((screenWidth - windowWidth) / 2);
        int windowPositionY = (int) Math.floor((screenHeight - windowHeight) / 2);

        snakerFrame.setTitle("大柏哥的贪吃不死蟒");
        snakerFrame.setBounds(windowPositionX, windowPositionY, windowWidth, windowHeight);
        // 设置窗口关闭按钮的默认操作(点击关闭时退出进程)
        snakerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        snakerFrame.setBackground(Color.cyan);
        snakerFrame.setLocationRelativeTo(null);
        snakerFrame.addKeyListener(new KeyMonitor());
        snakerFrame.setVisible(true);

    }
    public static void initSnaker () {
        Snaker snaker = new Snaker();
        SnakeContext.getInstance().setContext("snaker" , snaker);
    }
    public static void initFood (){
        Food food= new Food(Snaker.SW,Snaker.SH) ;
        food.random();
        SnakeContext.getInstance().setContext("food",food);

    }
    //启动线程
    public static void runThread () {
        SnakeDrawThread snakeDrawThread = new SnakeDrawThread();
        Thread snakeDrawMainThread = new Thread(snakeDrawThread);
        snakeDrawMainThread.start();

        SnakeRunThread snakeRunThread = new SnakeRunThread();
        Thread snakeRunMainThread = new Thread(snakeRunThread);
        snakeRunMainThread.start();

        SnakeContext.getInstance().setContext("snakeDrawThread",snakeDrawThread);
        SnakeContext.getInstance().setContext("snakeRunThread" ,snakeRunThread);

    }

}
//视图部分
//class Timer extends Frame {
//    Timer (String s){
//        super(s);
//    }
//    private boolean start=false;
//    Random food = new Random(100);
//    private List<SnakeBody> bodys = null;
//    private int len = 6;
//    int[] X0=new int[650];
//    int[] Y0=new int[500];
//    int a = 100;
//    int b = 200;
//    int X1 = food.nextInt(650);
//    int Y1 = food.nextInt(500);
//    public void launchFrame() {
//        Frame f = this;
//        Panel1 p = new Panel1();
//        Button b1 = new Button("start");
//        Button b2 = new Button("stop");
//        Button b3 = new Button("Invincible");
//        setLayout(null);
//        setBounds(100, 200, 800, 500);
//        p.setBounds(0, 0, 650, 500);
//        b1.setBounds(650, 150, 140, 50);
//        b2.setBounds(650, 200, 140, 50);
//        b3.setBounds(650, 250, 140, 50);
//        b1.setBackground(Color.YELLOW);
//        b2.setBackground(Color.YELLOW);
//        b3.setBackground(Color.GREEN);
//        p.setBackground(Color.PINK);
//        p.addKeyListener(new KeyMonitor());
//        setBackground(Color.cyan);
//        //键盘事件
//        b1.addActionListener(new Monitor4());
//        b2.addActionListener(new Monitor5());
//        b3.addActionListener(new Monitor6());
//
//        add(p);
//        add(b1);
//        add(b2);
//        add(b3);
//        setVisible(true);
//        addWindowListener(new MyWindow1());
//
//    }
    //关闭窗口
//    class MyWindow1 extends WindowAdapter {
//        public void windowClosing(WindowEvent e) {
//            setVisible(false);//关闭图像
//            System.exit(0);
//        }
//    }
    //画蛇，
//        class Panel1 extends Panel   {
//        ArrayList<Integer> sbs =new ArrayList<Integer>();
//             public void paint (Graphics g) {
//
//                Color c = g.getColor();//拿到当前画笔的颜色
//                g.setColor(Color.RED);//设置为红色
//                 int X0 = 325; int Y0 = 200;
//                for (int i = 0; i <len -1; i++) {
//                    X0 = 325 + i * 10;
//                    g.fillOval(X0, Y0, 10, 10);
//                    g.setColor(Color.MAGENTA);
//
//                    if (X0 != X1 && Y0 != Y1) {
//                        g.fillOval(X1, Y1, 10, 10);
//                    }
//                    if (X0 == X1 && Y0 == Y1) {
//                        continue;
//                    }
////                    repaint();
//           }
//        }
//    }

class Food {
    private int x ;
    private int y ;
    private int w;
    private int h;

   public Food(){
        this(25,25);
    }
    public Food(int w, int h ){
        this.x =-1;
        this.y =-1;
        this.w = w;
        this.h = h;
    }
    public Food (int x, int y ,int w,int h){
        this.x =x;
        this.y=y;
        this.w=w;
        this.h=h;
    }
    public void random(){
        int randomFoodX = ((int)Math.floor(Math.random() * (RetroSnaker.WindowWidth / Snaker.SW)));
        int randomFoodY = ((int)Math.floor(Math.random() * (RetroSnaker.WindowHetght /Snaker.SH)));
        this.x = randomFoodX;
        this.y = randomFoodY;

    }
    public int  getX (){
       return x;
    }
    public Food setX (int x){
       this.x = x;
       return this;
    }
    public int getY () {
       return y;
    }
    public Food setY (int y ) {
       this.y = y ;
       return this;
    }
    public int getW () {
       return w;
    }
    public Food setW ( int w) {
       this.w = w;
        return this;
    }
    public int getH () {
       return h;
    }
    public Food setH(int h){
       this.h = h;
       return this;
    }
}

class Snaker {
    public static final int SW = 25;//蛇的宽
    public static final int SH = 25;//蛇的高
    private List<SnakerBody> snakeBody = null;//
    public Direction currentdirection = null;//当前方向

    //用枚举定义方向
    public static enum Direction {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM

    }

    public Snaker() {

        snakeBody = new ArrayList<SnakerBody>();
        Direction[] randomDirectionBase = new Direction[]{
                Direction.LEFT,
                Direction.RIGHT,
                Direction.TOP,
                Direction.BOTTOM
        };

        // 当前方向根据 方向枚举进行随机
        currentdirection = randomDirectionBase[(int) Math.floor(Math.random() * 4)];
        //初始化蛇身
        initSnakerBody();
    }
//初始化蛇身
    private void initSnakerBody() {
        int SnakerHeadX = (int) Math.floor (Math.random() * (RetroSnaker.WindowWidth / SW-5)+5);
        int SnakerHeadY = (int) Math.floor((Math.random() * (RetroSnaker.WindowHetght / SH)-5) + 5);

        for (int i = 0; i < 3; i++) {
            //如果当前方向等于East
            if (Direction.LEFT == currentdirection) {
                SnakerBody snakeBodyItem = new SnakerBody()
                        .setX(SnakerHeadX + i)
                        .setY(SnakerHeadY)
                        .setWidth(SW)
                        .setHeight(SH);
                getsnakeBody().add(snakeBodyItem);
            } else if (Direction.RIGHT == currentdirection) {

                SnakerBody snakeBodyItem = new SnakerBody()
                        .setX(SnakerHeadX - i)
                        .setY(SnakerHeadY)
                        .setHeight(SW)
                        .setWidth(SH);
               getsnakeBody().add(snakeBodyItem);
            } else if (Direction.TOP == currentdirection) {
                SnakerBody snakeBodyItem = new SnakerBody()
                        .setX(SnakerHeadX)
                        .setY(SnakerHeadY - i)
                        .setWidth(SW)
                        .setHeight(SH);
                getsnakeBody().add(snakeBodyItem);
            } else if (Direction.BOTTOM == currentdirection) {
                SnakerBody snakeBodyItem = new SnakerBody()
                        .setX(SnakerHeadX)
                        .setY(SnakerHeadY + i)
                        .setWidth(SW);
              getsnakeBody().add(snakeBodyItem);
            }
        }
    }


//获取蛇头
    public SnakerBody getHead() {
        if (snakeBody != null && snakeBody.size() != 0 ){
            return snakeBody.get(0);
        } else {
            return null;
        }
    }
    //获取蛇尾
    public SnakerBody getTail () {
        if (snakeBody != null && snakeBody.size() !=0){
            return snakeBody.get(snakeBody.size() - 1);
        }else {
            return null;
        }
    }
    //获取长度
    public int getSize () {
        if(snakeBody != null){
            return snakeBody.size();
        }else {

            return 0;

        }
    }
//根据 蛇尾和蛇尾倒数第二个计算出蛇尾的移动方向，判断蛇身体应该添加到哪一边
    //增加身体
    public Snaker addBody (){
        Direction SnakerTailDirection = null;
        SnakerBody lastSnakerBoby = this.getTail();
        SnakerBody previousOfLastSnakeBody = this.getsnakeBody().get(this.getsnakeBody().size() - 2);
        //如果蛇尾的坐标X 和  蛇尾前一个蛇身的坐标X相同，则是上下移动
        if ( previousOfLastSnakeBody.getX() == lastSnakerBoby.getX()){

            if( previousOfLastSnakeBody.getY() > lastSnakerBoby.getY()){//蛇尾前一个蛇身坐标Y，大于蛇尾坐标Y时向上移动
                SnakerTailDirection = Direction.TOP;
            } else {
                  SnakerTailDirection = Direction.BOTTOM;//小于时向下移动
            }
        }else {
            if (previousOfLastSnakeBody.getX() < lastSnakerBoby.getX()){//蛇尾的前一个蛇身坐标X大于蛇尾坐标X时向左移动
                SnakerTailDirection = Direction.LEFT;//向左移动
            }else {
                SnakerTailDirection = Direction.RIGHT;//向右移动
            }
        }
        //当蛇尾的方向等于左时，坐标X 加1
        if ( Direction.LEFT == SnakerTailDirection){
            SnakerBody snakerBodyItem =  new SnakerBody()
                    .setX(lastSnakerBoby.getX()+1)
                    .setY(lastSnakerBoby.getY())
                    .setWidth(SW)
                    .setHeight(SH);
            getsnakeBody().add(snakerBodyItem);
            } else if (Direction.RIGHT == SnakerTailDirection) {
                SnakerBody snakerBodyItem = new SnakerBody()
                        .setX(lastSnakerBoby.getX()-1)
                        .setY(lastSnakerBoby.getY())
                        .setWidth(SW)
                        .setHeight(SH);
                getsnakeBody().add(snakerBodyItem);
        }else if (Direction.TOP == SnakerTailDirection){
            SnakerBody snakerBodyItem = new SnakerBody()
                    .setX(lastSnakerBoby.getX())
                    .setY(lastSnakerBoby.getY()+1)
                    .setWidth(SW)
                    .setHeight(SH);
            getsnakeBody().add(snakerBodyItem);
        }else if ( Direction.BOTTOM == SnakerTailDirection){
            SnakerBody snakerBodyItem = new SnakerBody()
                    .setX(lastSnakerBoby.getX())
                    .setY(lastSnakerBoby.getY()-1)
                    .setWidth(SW)
                    .setHeight(SH);
            getsnakeBody().add(snakerBodyItem);
        }

        return null;
    }
//  设置当前方向
    public Snaker setCurrentDirection(Direction d ) {
        this.currentdirection = d;
        return this;
    }
    //检查是否出界
    public boolean isBeachBound() {
        if ((this.getHead().getX() <= 0 && this.currentdirection == Direction.LEFT)
                || (this.getHead().getX() >= (RetroSnaker.WindowWidth / SW) && this.currentdirection == Direction.RIGHT)
                || (this.getHead().getY() <= 0 && this.currentdirection == Direction.TOP)
                || (this.getHead().getY() >= (RetroSnaker.WindowHetght / SH) && this.currentdirection == Direction.BOTTOM)) {

            return true;
        } else {
            return false;
        }
    }

    public List<SnakerBody> getsnakeBody() {
        return this.snakeBody;
    }

}
  class SnakerBody {
    private int x;
    private int y;
    private int width;
    private int height;


    public SnakerBody(){  }
    public SnakerBody(int x, int y, int width, int height) {

        this.x = x;

        this.y = y;

        this.width = width;

        this.height = height;

    }
    public int getX (){
        return x;
    }
    public SnakerBody setX (int x) {
        this.x = x;
        return this;
    }
    public int getY (){
        return y;
    }
    public SnakerBody setY(int y){
        this.y = y;
        return this;
    }
    public int getWidth () {
        return width;
    }
    public SnakerBody setWidth(int sw) {
        this.width = sw;
        return this;
    }
    public int getHeight () {
        return height;
    }
    public SnakerBody setHeight(int height){
        this.height =height;
        return this;
    }


  }

//class Monitor4 implements ActionListener {
//    public void actionPerformed(ActionEvent e) {
//
//        System.out.println("启动游戏");

class KeyMonitor extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();

        System.out.println("Key Pressed   " + keyCode + "    " + keyChar);//按下了哪个键
        Snaker snaker = (Snaker)SnakeContext.getInstance().getContext("snaker");
            //如果 按键上或者W
        if(keyCode ==  38 || keyCode == 87  ){
            snaker.setCurrentDirection(Snaker.Direction.TOP);//执行蛇对象向上转
        }
        //按下或者s键
        if(keyCode == 40 || keyCode == 83  ){
            snaker.setCurrentDirection(Snaker.Direction.BOTTOM);
        }
        //按左或者a键
        if(keyCode == 37 || keyCode == 65  ){
            snaker.setCurrentDirection(Snaker.Direction.LEFT);
        }
        //按右或者d键
        if(keyCode == 39 || keyCode == 68  ){
            snaker.setCurrentDirection(Snaker.Direction.RIGHT);
        }
        //输出蛇的方向信息
        System.out.println(snaker.currentdirection);
//        if (keyCode == KeyEvent.VK_UP) {
//            System.out.println("上");
//        }
//        if (keyCode == KeyEvent.VK_DOWN);
//        System.out.println("下");
//        if (keyCode == KeyEvent.VK_LEFT);
//        System.out.println("左");
//        if (keyCode == KeyEvent.VK_RIGHT);
//        System.out.println("右");
    }
}
//
//        }
//    }

class Monitor5 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("关闭游戏");

        }
    }

    class Monitor6 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("启动无敌模式");
        }
    }

