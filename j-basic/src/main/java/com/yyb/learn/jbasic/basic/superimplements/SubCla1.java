package com.yyb.learn.jbasic.basic.superimplements;

/**
 * @description: Sub Class
 * @author: Mr.Yu
 * @date: 2020-08-20 10:19
 **/
public class SubCla1 extends SuperCla {
    private int n;

    public SubCla1() {
        super();
        System.out.println("Subcla()");
    }

    public SubCla1(int n) {
        super(100);
        System.out.println("SubCla(int n)");
        this.n = n;
    }

    @Override
    public void publicMethod() {
        super.publicMethod();
        System.out.println("SubCla1's override SuperCla's public method!");
    }
}
