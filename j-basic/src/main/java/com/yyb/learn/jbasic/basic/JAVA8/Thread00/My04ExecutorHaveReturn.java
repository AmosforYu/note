package com.yyb.learn.jbasic.basic.JAVA8.Thread00;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class My04ExecutorHaveReturn {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(">>>>>>Program Start!<<<<<<");
        Date startDate = new Date();

        int taskSize = 5;
        //创建一个容量为5的线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        //创建多个有返回值的任务
        List<Future<String>> futureTaskList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Callable<String> callable = new My03ImplCallable(i + " ");
            // 执行任务并获取Future对象
            Future<String> futureTask = pool.submit(callable);
            futureTaskList.add(futureTask);
        }

        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for (Future f : futureTaskList) {
            System.out.println(">>>" + f.get().toString());
        }

        Date endDate = new Date();
        System.out.println("程序开始时间：" + formatter.format(startDate) +
                "程序结束时间：" + formatter.format(endDate) +
                "程序运行时长【" + (endDate.getTime() - startDate.getTime()) + "毫秒】");

    }
}
