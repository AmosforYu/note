package com.yyb.learn.jbasics.basic.designpattern;

import com.yyb.learn.jbasics.basic.designpattern.B_01ShapeInterface;
import com.yyb.learn.jbasics.basic.designpattern.B_02AbstracFactory;
import com.yyb.learn.jbasics.basic.designpattern.B_02ColorInterface;
import org.apache.commons.lang.StringUtils;

/**
 * @description:普通工厂模式-工厂类
 * @author: Mr.Yu
 * @date: 2020-09-23 15:02
 **/
public class B_01ShapeFactory extends B_02AbstracFactory {

    public B_01ShapeInterface getShape(String shapeType) {
        if (StringUtils.isEmpty(shapeType)) {
            return null;
        }

        if (B_SpEnum.CIRCLE.getName().equals(shapeType)) {
            return new B_01ShapeCircle();
        } else if (B_SpEnum.SQUARE.getName().equals(shapeType)) {
            return new B_01ShapeSquare();
        }

        return null;
    }


    @Override
    public B_01ShapeInterface getShapeCla(String shapeType) {
        if (StringUtils.isEmpty(shapeType)) {
            return null;
        }

        if (B_SpEnum.CIRCLE.getName().equals(shapeType)) {
            return new B_01ShapeCircle();
        } else if (B_SpEnum.SQUARE.getName().equals(shapeType)) {
            return new B_01ShapeSquare();
        }

        return null;
    }

    @Override
    public B_02ColorInterface getColorCla(String colorType) {
        return null;
    }
}
