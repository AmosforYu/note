package com.yyb.learn.jbasics.basic.JAVA8.lambda;


/**
 * Lambda常用写法
 */
public class Lambda00 {
    private int id;
    private String name;

    public Lambda00(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lambda00{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    public static void main(String[] args) {
//
//
//        /* 无参无返回值接口 */
//        NoResultNoParam noResultNoParam = () -> {
//            System.out.println("[Lambda00.NoResultNoParam] test");
//        };
//        noResultNoParam.methodA();
//
//        NoResultNoParam noResultNoParam1 = new NoResultNoParam() {
//            @Override
//            public void methodA() {
//                System.out.println("[Ordinary.NoResultNoParam] test");
//            }
//        };
//        noResultNoParam1.methodA();
//
//        /* 一个参数无返回值接口 */
//        NoResultOneParam noResultOneParam = (int a) -> {
//            System.out.println("[NoResultOneParam]param 'a' is :" + a);
//            a = a + a;
//        };
//        noResultOneParam.method(33);
//
//        /* 多个参数无返回值接口 */
//        NoResultManyParam noResultManyParam = (int a, int b) -> {
//            System.out.println("[NoResultManyParam] param is a=" + a + ",b=" + b);
//        };
//        noResultManyParam.method(1, 2);
//
//        /* 无参有返回值接口 */
//        HaveResultNoParam haveResultNoParam = () -> {
//            System.out.println("[HaveResultNoParam] return '33'.");
//            return 33;
//        };
//        int i = haveResultNoParam.methodB();
//
//        /* 一个参数有返回值接口 */
//        HaveResultOneParam haveResultOneParam = (int x) -> {
//            System.out.println("[HaveResultOneParam] return 2*x'. x=" + x);
//            x *= 2;
//            return x;
//        };
//        int j = haveResultOneParam.method(33);
//
//        /* 多个参数有返回值接口 */
//        HaveResultManyParam haveResultManyParam = (int a, int b) -> {
//            System.out.println("[HaveResultManyParam] return a+b, a=" + a + ",b=" + b);
//            return a + b;
//        };
//        int k = haveResultManyParam.method(6, 9);
//
//    }
}
