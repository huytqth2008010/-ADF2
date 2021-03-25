package demo.s3;

public class Main {
    public static void main(String[] args){
        DemoThread dt = new DemoThread();
        dt.setName("Demo Thread 01");
        dt.start();
    }
}
