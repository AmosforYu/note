package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @description: 饿汉式，线程安全，非lazy初始化
 * @author: Mr.Yu
 * @date: 2020-09-24 18:31
 **/
public class C_03SingletonCurrUnLazy {
    private static C_03SingletonCurrUnLazy instance = new C_03SingletonCurrUnLazy();

    public C_03SingletonCurrUnLazy() {
    }

    public static C_03SingletonCurrUnLazy getInstance() {
        return instance;
    }
}
