package com.yyb.learn.jbasic.basic.currentThread;
public class Singleton {
    // 私有化构造函数
    private Singleton() {
    }

    // 没有volatile修饰单例对象
    private static Singleton instance = null;

    // 对外提供的工厂方法
    public static Singleton getInstance() {
        if (instance == null) { // 第一次检测
            synchronized (Singleton.class) {    // 同步锁
                if (instance == null) { // 第二次检测
                    instance = new Singleton(); // 初始化
                }
            }
        }
        return instance;
    }

}
//
