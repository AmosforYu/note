package com.yyb.learn.jbasics.basic.designpattern;

import com.yyb.learn.jbasics.basic.designpattern.B_01ShapeInterface;
import com.yyb.learn.jbasics.basic.designpattern.B_02AbstracFactory;
import com.yyb.learn.jbasics.basic.designpattern.B_02ColorInterface;
import org.apache.commons.lang.StringUtils;

/**
 * @description:
 * @author: Mr.Yu
 * @date: 2020-09-23 17:42
 **/
public class B_02ColorFactory extends B_02AbstracFactory {

    @Override
    public B_01ShapeInterface getShapeCla(String shapeType) {
        return null;
    }

    @Override
    public B_02ColorInterface getColorCla(String colorType) {
        if (StringUtils.isEmpty(colorType)) {
            return null;
        }

        if (B_CoEnum.RED.getName().equals(colorType)) {
            return new B_02ColorRed();
        } else if (B_CoEnum.BLUE.getName().equals(colorType)) {
            return new B_02ColorBlue();
        }

        return null;
    }
}
