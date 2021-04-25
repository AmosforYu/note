package com.yyb.learn.jbasics.basic.currentThread;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yamos
 * @description CustomThreadPoolTest
 * @date 2021/4/19 0019 10:34
 */
public class CustomThreadPoolTest {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        ThreadPoolExecutor myPool = new ThreadPoolExecutor(2, 2, 30L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                new MyFactory(),
                new MyPolicy());

        myPool.prestartAllCoreThreads();//预启动所有核心线程

        for (int i = 1; i < 11; i++) {
            Runnable myTask = new MyTask(String.valueOf(i));
            myPool.execute(myTask);
            count.getAndIncrement();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                if (count.get() <= 2) {
                    TimeUnit.SECONDS.sleep(60);
                }

                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.toString() + ", is running!");
        }

        @Override
        public String toString() {
            return "This thread's name is [my-thread-" + name + "]";
        }
    }

    static class MyFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(thread.getName() + " has been created!");
            return thread;
        }
    }

    static class MyPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.err.println(r.toString() + " was rejected!");
        }
    }


}
