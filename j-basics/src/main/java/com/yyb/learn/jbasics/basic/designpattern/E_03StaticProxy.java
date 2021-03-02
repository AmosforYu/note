package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @author Yamos
 * @description E_03Proxy
 * @date 2021/3/1 0001 15:20
 */
public class E_03StaticProxy implements E_01Subject{

    private E_02RealSubject realSubject;

    public E_03StaticProxy(E_02RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("pre method");
        realSubject.request();
        System.out.println("after method");
    }
}
