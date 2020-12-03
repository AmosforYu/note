package com.yyb.learn.jbasic.basic.designpattern;

/**
 * @description: 双重锁机制，双校验(DCL:double-check locking)，线程安全，lazy初始化
 * @author: Mr.Yu
 * @date: 2020-09-24 18:35
 **/
public class C_04SingletonCurrLazyDCL {
    private static C_04SingletonCurrLazyDCL instance;

    public C_04SingletonCurrLazyDCL() {
    }

    private static synchronized C_04SingletonCurrLazyDCL getIntance() {
        if (instance == null) {
            instance = new C_04SingletonCurrLazyDCL();
        }
        return instance;
    }

    private static synchronized C_04SingletonCurrLazyDCL getInstance() {
        if (instance == null) {
            synchronized (C_04SingletonCurrLazyDCL.class) {
                if (instance == null) {
                    instance = new C_04SingletonCurrLazyDCL();
                }
            }
        }
        return instance;
    }
}
