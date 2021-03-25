package demo.s3;

public class DemoTheardInterface {
    public static void main(String[] agrs){
        DemoThread2 dt2 = new DemoThread2();
        Thread t = new Thread(dt2);
        t.start();

        int x = 10;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<x;i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){}
                }
            }
        };
        Thread t2 = new Thread(r);
        t2.start();
    }

}
