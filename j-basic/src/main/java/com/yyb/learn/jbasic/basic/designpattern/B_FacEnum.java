package com.yyb.learn.jbasic.basic.designpattern;

/**
 * @description:
 * @author: Mr.Yu
 * @date: 2020-09-23 15:50
 **/
public enum B_FacEnum {
    SHAPE(0, "SHAPE"),
    COLOR(1, "COLOR");

    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    B_FacEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }
}
