package com.yyb.learn.jbasics.basic.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Yamos
 * @description E_04DynamicProxy
 * @date 2021/3/1 0001 15:35
 */
public class E_04JDKProxy {

    private Object target;

    public E_04JDKProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("pre method for every proxied method");
                        method.invoke(target, args);
                        System.out.println("after method for every proxied method");
                        return null;
                    }
                });
    }
}
