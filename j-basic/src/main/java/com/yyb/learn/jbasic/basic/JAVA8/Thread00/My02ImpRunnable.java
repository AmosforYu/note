package com.yyb.learn.jbasic.basic.JAVA8.Thread00;

/**
 * 实现Runnable类创建线程，覆写run()方法, 初始化对象作为new Thread()的入参
 */
public class My02ImpRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Implements Thread:name: " + Thread.currentThread().getName()
                + ", id: " + Thread.currentThread().getId());
    }
}
