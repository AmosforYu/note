package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @description: 懒汉式，线程不安全，lazy初始化
 * @author: Mr.Yu
 * @date: 2020-09-23 18:38
 **/
public class C_01SingletonUncurrLazy {
    private static C_01SingletonUncurrLazy c_singletonUncurrLazy;

    public C_01SingletonUncurrLazy() {
    }

    private C_01SingletonUncurrLazy getInstance() {
        if (c_singletonUncurrLazy == null ) {
            c_singletonUncurrLazy = new C_01SingletonUncurrLazy();
        }
        return c_singletonUncurrLazy;
    }
}
