package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @description: 懒汉式，线程安全，lazy初始化
 * @author: Mr.Yu
 * @date: 2020-09-23 18:41
 **/
public class C_02SingletonCurrLazy {
    private static C_02SingletonCurrLazy c_singletonCurrLazy;

    public C_02SingletonCurrLazy() {
    }

    private static synchronized C_02SingletonCurrLazy getIntance() {
        if (c_singletonCurrLazy == null) {
            c_singletonCurrLazy = new C_02SingletonCurrLazy();
        }
        return c_singletonCurrLazy;
    }

}
