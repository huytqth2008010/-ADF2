package demo.s2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] agrs){
        Generic g = new Generic();
        g.demoGeneric(1.5);
        Generic<String,Integer> g2 = new Generic<>();
        g2.key = "hello";
        g2.value = 13;

        Generic<Integer,String> g3 = new Generic<>();
        g3.key = 12;

        Actor<Integer> aVn = new Actor<>();
        aVn.id = 10;
        aVn.name = "Hello world";

        Actor<String> aVg = new Actor<>();
        aVg.id = "Hello world";
        aVg.name = "Hello world";

        ActorUs us = new ActorUs();
        us.id = "Hello world";

        ArrayList<? super Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1.5);
    }
}
