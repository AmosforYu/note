package com.yyb.learn.jbasic.basic.currentThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {

    public static volatile int count = 0;

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static final int THREAD_POOL_SIZE = 20;

    public static CountDownLatch countDownLatch = new CountDownLatch(THREAD_POOL_SIZE);

    public static void add() {
//        count++; 非原子操作， 取值， ++1， 赋值
        atomicInteger.getAndIncrement(); //原子操作
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_POOL_SIZE];

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        add();
                    }
                    countDownLatch.countDown();
                }
            });
            threads[i].start();
        }
        countDownLatch.await();

//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }

        Thread.currentThread().getThreadGroup().list();
        System.out.println(atomicInteger.get());


    }

}
