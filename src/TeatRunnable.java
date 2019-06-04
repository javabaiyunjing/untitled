public class TeatRunnable implements Runnable  {
    int  b =  100;

    public synchronized void  m1 (){
        int b = 2000;
        try{
            Thread .sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("b = " +b);
    }
    public synchronized   void m2 (){
        try {
            Thread.sleep(5000);
        }catch(Exception e ){
            e.printStackTrace();
        }
        int b = 2500;
        System.out.println("b = " +b);
        }
    public void run(){
        try{
            m1();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main ( String agrs [] ) {
        TeatRunnable  tt   = new  TeatRunnable();
         Thread t = new Thread (tt);
         t.start();

         tt.m2();
         System.out.println(tt.b);
    }
}




