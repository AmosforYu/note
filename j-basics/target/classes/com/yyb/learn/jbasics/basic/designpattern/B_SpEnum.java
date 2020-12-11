package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @description:
 * @author: Mr.Yu
 * @date: 2020-09-23 15:50
 **/
public enum B_SpEnum {
    CIRCLE(0, "CIRCLE"),
    SQUARE(1, "SQUARE");

    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    B_SpEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }
}
