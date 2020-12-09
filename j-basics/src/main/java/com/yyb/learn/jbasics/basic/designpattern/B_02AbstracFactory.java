package com.yyb.learn.jbasics.basic.designpattern;

import com.yyb.learn.jbasics.basic.designpattern.B_02ColorInterface;

/**
 * @description:
 * @author: Mr.Yu
 * @date: 2020-09-23 17:38
 **/
public abstract class B_02AbstracFactory {
    public abstract B_01ShapeInterface getShapeCla(String shapeType);
    public abstract B_02ColorInterface getColorCla(String colorType);
}
