package com.yyb.learn.jbasic.basic.JAVA8.Thread00;

/**
 * 继承Thread类创建线程，覆写run()方法
 * ① Thread类本质上是实现了Runnable接口，Thread对象代表一个线程的实例。
 * ② Runnable接口只有一个抽象的run()方法。
 * ③ 启动线程的唯一方法就是通过Thread类的start()实例方法。
 * ④ start()方法是一个native方法，它将启动一个新线程，并执行run()方法。
 * ⑤ 自定义类直接extend Thread，并复写run()方法，就可以启动新线程并执行自己定义的run()方法。
 */
public class My01ExThread extends Thread {

    public My01ExThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Extends Thread:name: " + Thread.currentThread().getName()
                + ", id: " + Thread.currentThread().getId());
    }
}
