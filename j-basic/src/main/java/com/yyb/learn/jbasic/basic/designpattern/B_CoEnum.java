package com.yyb.learn.jbasic.basic.designpattern;

/**
 * @description:
 * @author: Mr.Yu
 * @date: 2020-09-23 15:50
 **/
public enum B_CoEnum {
    RED(0, "RED"),
    BLUE(1, "BLUE"),
    BLACK(1, "BLACK");

    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    B_CoEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }
}
