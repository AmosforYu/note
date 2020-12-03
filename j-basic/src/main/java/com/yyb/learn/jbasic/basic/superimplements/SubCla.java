package com.yyb.learn.jbasic.basic.superimplements;

/**
 * @description: Sub Class
 * @author: Mr.Yu
 * @date: 2020-08-20 10:19
 **/
public class SubCla extends SuperCla {
    private int n;

    public SubCla() {
        System.out.println("Subcla()");
    }

    public SubCla(int n) {
        System.out.println("SubCla(int n)");
        this.n = n;
    }

    @Override
    public void publicMethod() {
        System.out.println("SubCla's override SuperCla's public method!");
    }

    public void publicMethod2() {
        System.out.println("SubCla's  public method2!");
    }

    public String publicMethod2(String value) {
        System.out.println("SubCla's  overload public method2!");
        forSubClaMethod(1);
        return value;
    }
}
