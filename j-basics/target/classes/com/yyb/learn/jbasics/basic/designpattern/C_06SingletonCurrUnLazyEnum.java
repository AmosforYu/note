package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @description: 枚举类，线程安全，非lazy初始化
 * @author: Mr.Yu
 * @date: 2020-09-24 19:10
 **/
public enum C_06SingletonCurrUnLazyEnum {
    INSTANCE;

    public void oneMethod() {
        System.out.println("");
    }

}
