package com.yyb.learn.jbasics.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Yamos
 * @description SingleScheduleExecutor
 * @date 2021/4/16 0016 15:40
 */
public class SingleScheduleExecutor {

    private static final long DAYMILLIS = 24 * 60 * 60 * 1000L;
    /*
    SingleThreadPool的等待队列长度为Integer.MAX_VALUE， 可能会堆积大量请求，从而导致OOM，代码中不允许使用
    newFixedThreadPool和newSingleThreadExecutor:使用LinkedBlockingQueue<Runnable>作为等待队列
    newCachedThreadPool和newScheduledThreadPool的线程池容量为Integer.MAX_VALUE
     */
    private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    private static final ScheduledExecutorService sss = Executors.newScheduledThreadPool(1);

    /*
    todo:正确创建使用线程池的方法
     */
    private static final ExecutorService slefPool = new ThreadPoolExecutor(1, 1,
            60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));

    /**
     * 每天定时执行一次
     *
     * @param time     执行的时间点
     * @param runnable 执行的任务
     */
    public static void dayOfDelay(String time, Runnable runnable) {
//        long period = DAYMILLIS;
        long period = 60 * 1000L;
        long initDelay = getTimeMillis(time) - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : period + initDelay;

        scheduledExecutor.scheduleAtFixedRate(
                runnable,
                initDelay,
                period,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 获取给定时间对应的毫秒数
     *
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        LocalDate nowDay = LocalDate.now();
        String timeDate = nowDay.toString() + " " + time;
        LocalDateTime nowDate = LocalDateTimeUtils.parseLocalDateTime(timeDate);
        return LocalDateTimeUtils.date2Millis(nowDate);
    }
}
