package com.rainple.designpattern.prototype;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep test = new Sheep("test","白色");
        System.out.println(test);
        Sheep clone = (Sheep) test.clone();
        clone.setColor("黑色");
        clone.setName("test01");
        System.out.println(test);
        System.out.println(clone);
    }

}
