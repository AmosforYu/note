package com.yyb.learn.jalonetask.utils;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Yamos
 * @description TimingTaskUtil
 * @date 2021/3/4 0004 16:08
 */
public class TimingTaskUtil {
    private static final ConcurrentMap<String, ScheduledFuture> timingTaskMap = new ConcurrentHashMap<>();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static final Map<Long, String> taskhistorical = new HashMap<>();

    /**
     * 创建一个定时任务
     *
     * @param taskName     任务名称
     * @param initialDelay 延时开始
     * @param period       执行周期
     * @param command      任务线程
     * @param mandatory    (存在)强制创建
     */
    public static boolean CreateTimingTask(String taskName, long initialDelay,
                                           long period, Runnable command, boolean mandatory) {
        if (FindTimingTask(taskName)) {
            System.out.println("定时任务存在。");
            if (mandatory) {
                System.out.println("强制创建");
                CancelTimingTask(taskName);
                ScheduledFuture future = scheduler.scheduleAtFixedRate(command, initialDelay, period, TimeUnit.SECONDS);
                timingTaskMap.put(taskName, future);
            } else {
                return false;
            }
        } else {
            return false;
        }

        ScheduledFuture future = scheduler.scheduleAtFixedRate(command, initialDelay, period, TimeUnit.SECONDS);
        timingTaskMap.put(taskName, future);
        return true;
    }

    /**
     * 创建一个一次性的延迟任务
     *
     * @param initialDelay 延时开始
     * @param command      任务线程
     */
    public static void CreateTask(String name, long initialDelay, Runnable command) {
        try {
            scheduler.schedule(command, initialDelay, TimeUnit.SECONDS);
            taskhistorical.put(System.currentTimeMillis(), name);
        } catch (Exception e) {
            System.out.println("任务执行失败");
        }
    }

    /**
     * 根据名称查询定时任务
     *
     * @param taskName 任务名称
     * @return true任务存在  false任务取消
     */
    public static boolean FindTimingTask(String taskName) {

        try {
            ScheduledFuture scheduledFuture = timingTaskMap.get(taskName);
            if (scheduledFuture != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 查询定时任务列表
     *
     * @return 任务名称集合
     */
    public static Set<String> FindListTimingTask() {
        return timingTaskMap.keySet();
    }

    /**
     * 根据名称取消定时任务
     *
     * @param taskName 任务名称
     */
    public static boolean CancelTimingTask(String taskName) {
        try {
            if (FindTimingTask(taskName)) {
                boolean b = timingTaskMap.get(taskName).cancel(true);
                timingTaskMap.remove(taskName);
                return b;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    private TimingTaskUtil() {
    }

}
