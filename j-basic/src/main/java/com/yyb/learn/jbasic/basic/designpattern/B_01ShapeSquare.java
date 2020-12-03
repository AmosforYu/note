package com.yyb.learn.jbasic.basic.designpattern;

/**
 * @description: 工厂输出的具体对象
 * @author: Mr.Yu
 * @date: 2020-09-23 15:22
 **/
public class B_01ShapeSquare implements B_01ShapeInterface {
    @Override
    public Double getArea(double x) {
        System.out.println("[SQUARE] side is:" + x);
        return x * x;
    }
}
