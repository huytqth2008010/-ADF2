package demo.s4;

public class Prime {
    int x = 1;
    int y = 1;
    int z = 1;

    public void tangXY(){
        x++;
        y++;
    }
    public void inKetQua(){
        System.out.println(Thread.currentThread().getName()+"----");
        System.out.println("X = "+ x);
        System.out.println("Y = "+ y);
    }
    public synchronized void thaydoiXY(){
        tangXY();
        inKetQua();
    }
    public synchronized void thaydoiZ(){
        z++;
        System.out.println(Thread.currentThread().getName()+"---");
        System.out.println("z = "+z);
    }
}
