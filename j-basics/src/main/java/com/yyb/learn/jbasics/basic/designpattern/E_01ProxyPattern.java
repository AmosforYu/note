package com.yyb.learn.jbasics.basic.designpattern;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author Yamos
 * @description E_01ProxyPattern
 * 代理模式-静态代理，静态代理有两大劣势：
 * 1.代理类只能代理一个委托类(其实可以代理多个，但是不符合单一职责原则)
 * 2.如果委托类的每个方法都需要一个统一处理方法，就需要在代理类中实现多次重复代码
 * @date 2021/3/1 0001 15:10
 */
public class E_01ProxyPattern {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //委托方（被代理方）
        E_02RealSubject realSubject = new E_02RealSubject();

        //代理方
        E_03StaticProxy proxy = new E_03StaticProxy(realSubject);

        //代理方替委托方发出请求
        proxy.request();

        System.out.println(realSubject.getClass());
        //JDK动态代理-代理方
        E_01Subject subject = (E_01Subject) new E_04JDKProxy(realSubject).getProxyInstance();
        System.out.println(subject.getClass());
        subject.request();

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "E:\\Program Files\\JAVA\\01myProject\\hy\\j-basics\\src\\main\\java\\com\\yyb\\learn\\jbasics\\basic\\designpattern\\CGLIBProxyClass");
        //CGLIB动态代理
        Enhancer enhancer = new Enhancer();
        //设置目标类
        enhancer.setSuperclass(E_02RealSubject.class);
        // 设置拦截对象
        enhancer.setCallback(new E_05CGLIBProxy());
        // 生成代理类并返回一个实例
        E_02RealSubject target = (E_02RealSubject) enhancer.create();
        target.request();
    }

}
