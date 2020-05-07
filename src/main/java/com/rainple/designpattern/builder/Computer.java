package com.rainple.designpattern.builder;

/**
 * @InterfaceName: Computer
 * @description:
 * @author: rainple
 * @create: 2020-05-07 12:42
 **/
public class Computer {


    private String gpu;
    private String cpu;
    private String ram;
    private String mainboard;
    private String power;

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMainboard() {
        return mainboard;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "gpu='" + gpu + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", mainboard='" + mainboard + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
