package com.yyb.learn.jbasics.basic.currentThread;

import com.yyb.learn.jbasics.utils.SingleScheduleExecutor;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yamos
 * @description LockTest
 * @date 2021/4/15 0015 10:34
 */
public class LockTest {
    private static long start = System.currentTimeMillis();

    private static final Lock lock = new ReentrantLock();

    private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            long end = System.currentTimeMillis();

            @Override
            public void run() {
                System.out.println("time wait:[" + (end - start) + "],this is 线程1");
            }
        };

        SingleScheduleExecutor.dayOfDelay("17:59:00", runnable);
    }
}
