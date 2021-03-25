package demo.s4;

public class Account {
    int balance;
    public void napTien(int amount){
        balance+=amount;
        System.out.println("Nap" + amount + "thanh cong");
        try {
            notify();//Baao cao
        }catch (Exception e){}
    }
    public void rutTien(int amount){
      if(balance < amount){
          System.out.println("Xin vui long cho");
          try {
              wait();
          }catch (Exception e){}

       }
          balance-=amount;
          System.out.println("Rut" + amount + "thanh cong");

    }
}
