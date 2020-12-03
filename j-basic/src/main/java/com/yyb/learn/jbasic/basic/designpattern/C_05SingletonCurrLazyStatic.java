package com.yyb.learn.jbasic.basic.designpattern;

/**
 * @description: 登记式，静态内部类，线程安全，lazy初始化
 * @author: Mr.Yu
 * @date: 2020-09-24 19:01
 **/
public class C_05SingletonCurrLazyStatic {
    private static class SingletonHolder {
        private static final C_05SingletonCurrLazyStatic INSTANCE = new C_05SingletonCurrLazyStatic();
    }

    private C_05SingletonCurrLazyStatic() {
    }

    public static final C_05SingletonCurrLazyStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
