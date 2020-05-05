package com.rainple.designpattern.prototype;

import java.io.Serializable;

public class Color implements Cloneable, Serializable {

    private String color;

    public Color() {
    }

    public Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Color{" +
                "color='" + color + '\'' +
                '}';
    }
}
