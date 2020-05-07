package com.rainple.designpattern.builder;

/**
 * @className: MacComputer
 * @description:
 * @author: rainple
 * @create: 2020-05-07 12:47
 **/
public class MacComputerBuilder extends Builder {

    private Computer computer;

    public MacComputerBuilder() {
        computer = new Computer();
    }

    @Override
    void buildGpu() {
        computer.setGpu("atx");
        System.out.println("mac book is building gpu");
    }

    @Override
    void buildCpu() {
        computer.setCpu("intel i7");
        System.out.println("mac book is building cpu");
    }

    @Override
    void buildRam() {
        computer.setRam("三星");
        System.out.println("mac book is building ram");
    }

    @Override
    void buildMainboard() {
        computer.setMainboard("microStar");
        System.out.println("mac book is building main board");
    }

    @Override
    void buildPower() {
        computer.setPower("战斧");
        System.out.println("mac book is building power");
    }

    @Override
    Computer getComputer() {
        return computer;
    }
}
