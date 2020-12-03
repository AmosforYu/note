package com.yyb.learn.jbasic.basic.JAVA8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

/**
 * Lambda简化写法
 */
public class Lambda01 {
    //0.基础写法
    NoResultManyParam noResultManyParam = (int a, int b) -> {
        System.out.println("a+b=" + (a + b));
    };

    // 1.可以省略入参类型
    NoResultManyParam manyParam = (a, b) -> {
        System.out.println("省略参数类型");
    };

    //2.只有一个入参时，可省略括号
    NoResultOneParam oneParam = x -> {
        System.out.println("省略参数括号");
    };

    //3.如果待执行方法体只有一条代码，可省略大括号
    NoResultOneParam oneParam1 = x -> System.out.println("省略大括号");

    //4.如果待执行方法体只有一条代码，且是return语句，则可以省略大括号
    HaveResultManyParam haveResultManyParam = (a, b) -> a + b;


    /**
     * ====================================================================================================================================
     * 有时候不是必须重写某个匿名内部类的方法，可以使用Lambda表达式的接口快速指向一个已经被实现的方法
     * 1.接口的返回值类型必须与被指向的方法返回值类型一致；
     * 2.接口入参个数、顺序、类型必须与被指向方法的一致；
     */
    public static int addOne(int x) {
        return x + 1;
    }

    private int doubleSum(int x) {
        return 2 * x;
    }

//    public static void main(String[] args) {
//        Lambda01 lambda01 = new Lambda01();
//        HaveResultOneParam oneParam2 = Lambda01::addOne;
//        System.out.println(oneParam2.method(3));
//        HaveResultOneParam oneParam3 = lambda01::doubleSum;
//        System.out.println(oneParam3.method(3));
//    }

    /**
     * ====================================================================================================================================
     * 构造方法写法 略
     */

    /**
     * ====================================================================================================================================
     * 创建线程
     */
    Thread lambdaThread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("123");
        }
    });

//    public static void main(String[] args) {
//        System.out.println("thread name:" + Thread.currentThread().getName());
//        Thread thread2 = new Thread(() -> {
//            System.out.println("thread name:" + Thread.currentThread().getName());
//        });
//        thread2.start();
//    }

    /**
     * ====================================================================================================================================
     * 简化集合操作
     */
//    public static void main(String[] args) {
//        ArrayList<Integer> foreachList = new ArrayList();
//        Collections.addAll(foreachList, 1, 2, 3, 4);
//
//        //foreach遍历集合
//        foreachList.forEach(Lambda01::addOne);
//        foreachList.forEach(e -> System.out.println(2 * e));
//
//        //removeIf删除集合元素
//        ArrayList<Lambda00> removeList = new ArrayList();
//        removeList.add(new Lambda00(1, "y"));
//        removeList.add(new Lambda00(2, "u"));
//        removeList.add(new Lambda00(3, "b"));
//        removeList.forEach(System.out::println);
//        removeList.removeIf(lambda00 -> lambda00.getId() == 2);
//        removeList.forEach(System.out::println);
//
//        //sort集合元素排序
//        ArrayList<Lambda00> sortList = new ArrayList();
//        sortList.addAll(removeList);
//        sortList.sort((o1, o2) -> o2.getId() - o1.getId());
//        sortList.forEach(System.out::println);
//
//
//        /**
//         * 注意：Lambda表达式内使用的参数在编译期间会被标注为final
//         */
//        int num = 33;
//        Consumer<String> consumer = con -> System.out.println(num);
//        consumer.accept("yyb");
////        num += 2;//会报错Error:(116, 63) java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
//    }
}
