package Asm.s2;

import java.awt.*;

public class Student {
    String name;
    Integer age;
    Integer mark;


    public Student(String name, Integer age, Integer mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }


}
