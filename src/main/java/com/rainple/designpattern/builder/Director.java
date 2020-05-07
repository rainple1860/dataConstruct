package com.rainple.designpattern.builder;

/**
 * @className: Derector
 * @description:
 * @author: rainple
 * @create: 2020-05-07 12:52
 **/
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Computer build() {
        builder.buildGpu();
        builder.buildCpu();
        builder.buildMainboard();
        builder.buildPower();
        builder.buildRam();
        return builder.getComputer();
    }
}
