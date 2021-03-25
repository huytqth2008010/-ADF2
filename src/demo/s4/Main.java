package demo.s4;

public class Main {
    public static void main(String[] args){
        Prime p = new Prime();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<20;i++){
                  synchronized (p){
                      p.tangXY();
                      p.inKetQua();
                  }
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){}
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<20;i++){
                    synchronized (p){
                        p.tangXY();
                        p.inKetQua();
                    }
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){}
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<20;i++){
//                    synchronized (p){
//                        p.tangXY();
//                        p.inKetQua();
//                    }
                    p.thaydoiXY();
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){}
                }
            }
        });
        t1.start();
//        try {
//            t1.join();
//        }catch (Exception e){}
//        t2.setDaemon(true);//t2 se dung khi tat car cac luong da dungm
        t2.start();
        t3.start();
    }
}
