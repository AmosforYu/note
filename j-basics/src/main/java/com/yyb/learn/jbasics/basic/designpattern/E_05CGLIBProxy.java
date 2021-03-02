package com.yyb.learn.jbasics.basic.designpattern;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Yamos
 * @description E_05CGLIBProxy
 * @date 2021/3/1 0001 17:41
 */
public class E_05CGLIBProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("pre method for every proxied method");
        methodProxy.invokeSuper(o, objects);
        System.out.println("after method for every proxied method");
        return null;
    }
}
