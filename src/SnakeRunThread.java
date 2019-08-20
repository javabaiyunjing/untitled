import java.util.List;

public class SnakeRunThread  implements  Runnable {

    //运行速度
    private int speed = 300;

    public void run (){

        while (true) {
            Snaker snaker = (Snaker) SnakeContext.getInstance().getContext("snaker");
            Food food = (Food) SnakeContext.getInstance().getContext("food");

            try {
                Thread.sleep(speed);//睡眠300毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //r如果蛇头与食物重合
            if (snaker.getHead().getX() == food.getX() && snaker.getHead().getY() == food.getY()){
                System.out.println("吃到了食物"+snaker.getHead());
                food.random();//随机位置
                snaker.addBody();//增加身体
            }
            if (snaker.isBeachBound()){
                System.out.println("撞墙了老铁");
                continue;
            }
            List<SnakerBody> snakerBodyList = snaker.getsnakeBody();
                //除蛇头外，将蛇尾的前一个的坐标值剪切给前一个
            for ( int i = snakerBodyList.size()-1; i>0; i--){
                SnakerBody currentsnakerBody = snakerBodyList.get(i);//当前蛇身
                SnakerBody previousSnakeBody =snakerBodyList.get(i-1);//以前的蛇身

                int previonusX = previousSnakeBody.getX();
                int previomisY = previousSnakeBody.getY();

                currentsnakerBody.setX(previonusX).setY(previomisY);//剪切给前一个
            }

            //让蛇走起来
            SnakerBody snakerHead = snaker.getHead();

            if (snaker.currentdirection == Snaker.Direction.LEFT){
                snakerHead.setX(snakerHead.getX()-1);
            }else if(snaker.currentdirection == Snaker.Direction.RIGHT) {
                snakerHead.setX(snakerHead.getX()+1);

            }else if (snaker.currentdirection == Snaker.Direction.TOP) {
                snakerHead.setY(snakerHead.getY()-1);
            }else  if (snaker.currentdirection == Snaker.Direction.BOTTOM){
                snakerHead.setY(snakerHead.getY()+1);
            }

        }

    }
    public int getSpeed(){
        return speed;
    }
    public int setSpeed(int speed){
        this.speed = speed;
        return speed ;
    }
}
