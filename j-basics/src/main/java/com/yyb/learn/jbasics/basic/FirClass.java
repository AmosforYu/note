package com.yyb.learn.jbasics.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Calendar;

/**
 * @description:
 * @author: Mr.Yu
 * @date: 2020-08-13 16:59
 **/
public class FirClass implements Serializable {

    private static final String FINAL_NAME = "未知";

    private int id;
    private String name;

    public FirClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public FirClass() {

    }

//        //基本类型 byte\short\int\long\float\double\char\boolean
//        //StringBuffer是线程安全的

    /**
     * --|java修饰符：
     * ----|访问控制修饰符：private、protected、public、default
     * ----|非访问控制修饰符：final、abstract、static、synchronized、[transient]、[volatile]
     */
    public transient int limit = 55;   // 不会持久化
    public int b; // 持久化

    //通常情况下，在一个线程调用 run() 方法（在 Runnable 开启的线程），在另一个线程调用 stop() 方法。
    //如果第一行中缓冲区的 active 值被使用，那么在第二行的 active 值为 false 时循环不会停止。
    //但是以下代码中我们使用了 volatile 修饰 active，所以该循环会停止
    public class MyRunnable implements Runnable {
        private volatile boolean active;

        public void run() {
            active = true;
            while (active) // 第一行
            {
                // 代码
            }
        }

        public void stop() {
            active = false; // 第二行
        }
    }

//    public static void main(String[] args) throws IOException {
////        Calendar calendar = Calendar.getInstance();
////        System.out.println(calendar.get(Calendar.YEAR) + " " + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
////
////        calendar.set(Calendar.YEAR, 1993);
////        System.out.println(calendar.get(Calendar.YEAR) + " " + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
////
////        calendar.add(Calendar.MONTH, 1);
////        System.out.println(calendar.get(Calendar.YEAR) + " " + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
//
//        char c;
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符, 按下 'q' 键退出。");
//        // 读取字符
//        do {
//            c = (char) bufferedReader.read();
//            System.out.println(c);
//        } while (c != 'q');
//    }


}
