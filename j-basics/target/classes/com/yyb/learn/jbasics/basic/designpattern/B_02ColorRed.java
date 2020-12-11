package com.yyb.learn.jbasics.basic.designpattern;

import com.yyb.learn.jbasics.basic.designpattern.B_02ColorInterface;

/**
 * @description:
 * @author: Mr.Yu
 * @date: 2020-09-23 17:36
 **/
public class B_02ColorRed implements B_02ColorInterface {

    @Override
    public String getColor() {
        return "This is red";
    }
}
