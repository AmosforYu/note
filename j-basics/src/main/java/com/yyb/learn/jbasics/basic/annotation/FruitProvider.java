package com.yyb.learn.jbasics.basic.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Yamos
 * @description FruitProvider
 * @date 2020/12/16 0016 14:26
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    /**
     * 供应商编号
     */
    int id() default -1;

    /**
     * 供应商名称
     */
    String name() default "";

    /**
     * 供应商地址
     */
    String address() default "";
}
