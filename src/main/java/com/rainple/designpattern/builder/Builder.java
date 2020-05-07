package com.rainple.designpattern.builder;

/**
 * @className: Builder
 * @description:
 * @author: rainple
 * @create: 2020-05-07 12:45
 **/
public abstract class Builder {

    abstract void buildGpu();

    abstract void buildCpu();

    abstract void buildRam();

    abstract void buildMainboard();

    abstract void buildPower();

    abstract Computer getComputer();

}
