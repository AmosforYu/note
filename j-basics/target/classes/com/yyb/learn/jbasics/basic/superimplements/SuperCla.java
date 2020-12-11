package com.yyb.learn.jbasics.basic.superimplements;

/**
 * @description: Super Class
 * @author: Mr.Yu
 * @date: 2020-08-20 10:14
 **/
public class SuperCla {
    private int n;

    public SuperCla() {
        System.out.println("SuperCla()");
    }

    public SuperCla(int n) {
        System.out.println("SuperCla(int n)");
        this.n = n;
    }

    public void publicMethod() {
        System.out.println("SuperCla's public method!");
    }

    public void forSubClaMethod(int capacity) {
        System.out.println("capacity is :"  + capacity);
    }

}
