package com.yyb.learn.jbasic.basic.designpattern;

/**
 * @description: 工厂输出的具体对象
 * @author: Mr.Yu
 * @date: 2020-09-23 15:08
 **/
public class B_01ShapeCircle implements B_01ShapeInterface {

    @Override
    public Double getArea(double x) {
        System.out.println("[CIRCLE] radius is:" + x);
        return 3.14 * x * x;
    }
}
