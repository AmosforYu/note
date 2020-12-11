package com.yyb.learn.jbasics.basic.designpattern;

import org.apache.commons.lang.StringUtils;

/**
 * @description:
 * @author: Mr.Yu
 * @date: 2020-09-23 17:46
 **/
public class B_02FactoryProducer {
    public static B_02AbstracFactory getFactory(String factoryName) {
        if (StringUtils.isEmpty(factoryName)) {
            return  null;
        }

        if (B_FacEnum.SHAPE.getName().equals(factoryName)) {
            return new B_01ShapeFactory();
        } else if (B_FacEnum.COLOR.getName().equals(factoryName)) {
            return new B_02ColorFactory();
        }

        return  null;
    }
}
