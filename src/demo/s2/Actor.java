package demo.s2;

public class Actor<E> {
    E id;
    String name;

    //Chưa biết
    void run(E x){
        id = x;
    }
}
