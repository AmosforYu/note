package com.yyb.learn.jbasics.basic.JAVA8.Thread00;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewThread_MainTest {

//    public static void main(String[] args) {
//        /* 1.继承Thread，重写run()方法，Thread对象的start()方法启动线程 */
//        Thread extThread = new My01ExThread("extThread");
//        extThread.start();
//
//        /* 2.实现Runnable，重写run()方法, 作为Thread构造函数的入参，Thread对象的start()方法启动线程 */
//        Thread implRunnable = new Thread(new My02ImpRunnable(), "implRunnable");
//        implRunnable.start();
//
//        /* 3.实现Callable，重写call()方法，作为Future构造函数的入参，Future的对象作为Thread构造函数的入参，Thread对象的start()方法启动线程*/
//        My03ImplCallable myCallable = new My03ImplCallable("myCallable");
//        FutureTask task = new FutureTask(myCallable);
//        Thread implCallable = new Thread(task);
//        implCallable.start();
//        try {
//            System.out.println("实现Callable的线程返回值为： " + task.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        /* 4.线程池方式，通过Executor 的工具类可以创建三种类型的普通线程池，execute()无返回值， submit()有返回值Future */
//        /* 4.1 FixThreadPool(int n)  :定长线程池，常用的
//        适用于为了满足资源管理需求而需要限制当前线程数量的场合。适用于负载比较重的服务器。 */
//        ExecutorService fixPool = Executors.newFixedThreadPool(3);
//        System.out.println("[newFixedThreadPool] START");
//        for (int i = 0; i < 3; i++) {
//            fixPool.submit(new My02ImpRunnable());
//        }
//        if (!fixPool.isShutdown()) {
//            System.out.println("[newFixedThreadPool] to be shut down ");
//            fixPool.shutdown();
//        }
//        System.out.println("[newFixedThreadPool] END");
//
//        /* 4.2 SingleThreadPoolExecutor :单线程池
//        适用于需要保证顺序执行各个任务的场景 */
//        ExecutorService singlePool = Executors.newSingleThreadExecutor();
//        Future future;
//        System.out.println("[newSingleThreadExecutor] START");
//        try {
//            for (int i = 0; i < 3; i++) {
//                future = singlePool.submit(new My03ImplCallable("[singlePool]"));
//                System.out.println("[newSingleThreadExecutor] return is : " + future.get());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        if (!singlePool.isShutdown()) {
//            System.out.println("[newSingleThreadExecutor] to be shut down ");
//            singlePool.shutdown();
//        }
//        System.out.println("[newSingleThreadExecutor] END");
//
//        /* 4.3 CashedThreadPool()  :可缓存的线程池
//        “可缓存”意味着有任务进入时，线程池会调用已有线程或创建新的线程来执行；无任务时，空闲超过指定时间(默认时1分钟)，则线程会终止销毁
//        当提交任务速度高于线程池中任务处理速度时，缓存线程池会不断的创建线程,所以会有过度创建线程、消耗系统调度资源的隐患；
//        适用于提交短期的异步小程序，以及负载较轻的服务器 */
//        ExecutorService cachedPool = Executors.newCachedThreadPool();
//        System.out.println("[newCachedThreadPool] START");
//        for (int i = 0; i < 3; i++) {
//            cachedPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("[newCachedThreadPool] thread is running");
//                }
//            });
//        }
//        if (!cachedPool.isShutdown()) {
//            System.out.println("[newCachedThreadPool] to be shut down ");
//            cachedPool.shutdown();
//        }
//        System.out.println("[newCachedThreadPool] END");
//
//        /* 4.4 ScheduleThreadPool()  :固定线程数量的定时线程任务的线程池*/
//        ScheduledExecutorService schedulPool = Executors.newScheduledThreadPool(3);
//        System.out.println("[newScheduledThreadPool] START");
//        for (int i = 0; i < 3; i++) {
//            schedulPool.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("时间："+System.currentTimeMillis()+"--"+Thread.currentThread().getName() + "正在执行任务");
//                }
//            },3, TimeUnit.SECONDS);
//        }
//        if (!schedulPool.isShutdown()) {
//            System.out.println("[newScheduledThreadPool] to be shut down ");
//            schedulPool.shutdown();
//        }
//        System.out.println("[newScheduledThreadPool] END");
//
//        /* 4.5 newSingleThreadScheduledExecutor()  :只有一个线程的的定时任务线程池*/
//        ScheduledExecutorService es5 = Executors.newSingleThreadScheduledExecutor();
//        System.out.println("[newSingleThreadScheduledExecutor] START");
//        for (int i = 0; i < 3; i++) {
//            es5.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("时间："+System.currentTimeMillis()+"--"+Thread.currentThread().getName() + "正在执行任务");
//                }
//            },3, TimeUnit.SECONDS);
//        }
//        if (!es5.isShutdown()) {
//            System.out.println("[newSingleThreadScheduledExecutor] to be shut down ");
//            es5.shutdown();
//        }
//        System.out.println("[newSingleThreadScheduledExecutor] END");
//    }
}