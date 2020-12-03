package com.yyb.learn.jbasic.basic.superimplements;

/**
 * @description: Sub Class
 * @author: Mr.Yu
 * @date: 2020-08-20 10:19
 **/
public class SubCla2 extends SuperCla {
    private int n;

    public SubCla2() {
        super(200);
        System.out.println("Subcla()");
    }

    public SubCla2(int n) {
        super();
        System.out.println("SubCla(int n)");
        this.n = n;
    }
}
