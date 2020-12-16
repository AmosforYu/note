package com.yyb.learn.jbasics.basic.annotation;

/**
 * @author Yamos
 * @description FruitApp
 * @date 2020/12/16 0016 14:30
 */
public class FruitApp {
    public static void main(String[] args) {
        Apple apple = new Apple("111","222","333,newName,newAddress");

        FruitInfoUtil.getFruitInfo(apple.getClass());
    }
}
