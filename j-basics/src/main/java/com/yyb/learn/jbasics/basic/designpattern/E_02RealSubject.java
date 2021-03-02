package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @author Yamos
 * @description E_02RealSubject
 * @date 2021/3/1 0001 15:16
 */
public class E_02RealSubject implements E_01Subject{

    @Override
    public void request() {
        System.out.println("This is real demand!");
    }
}