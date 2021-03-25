package demo.s3;

public class DemoThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
}
