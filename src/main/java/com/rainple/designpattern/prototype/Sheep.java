package com.rainple.designpattern.prototype;

import java.io.*;

public class Sheep implements Cloneable, Serializable {

    private String name;
    private Color color = new Color();

    public Sheep() {
    }

    public Sheep(String name, String color) {
        this.name = name;

        setColor(color);
    }

    /**
     * 利用序列化与反序列化实现深克隆
     * @return
     */
    public Object deepClone() {
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);


            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return ois.readObject();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (bos != null) {
                    bos.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep clone = (Sheep) super.clone();
        clone.color = (Color) clone.color.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", color=" + color +
                '}';
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color.setColor(color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
