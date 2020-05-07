package com.rainple.designpattern.builder;

/**
 * @className: Client
 * @description:
 * @author: rainple
 * @create: 2020-05-07 12:54
 **/
public class Client {

    public static void main(String[] args) {
        Builder builder = new MacComputerBuilder();
        Director director = new Director(builder);
        Computer build = director.build();
        System.out.println(build);
    }

}
