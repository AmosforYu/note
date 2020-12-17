package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @author Yamos
 * @description D_02Stock 2.创建一个请求 类
 * @date 2020/12/17 0017 10:35
 */
public class D_02Stock {
    private String name = "ADG";
    private Integer quantity = 10;

    public D_02Stock(String name, Integer quantity) {
        if (isNotEmpty(name)) {
            this.name = name;
        }
        this.quantity = quantity;
    }

    private boolean isNotEmpty(String str) {
        return null != str && !"".equals(str);
    }

    public void buy() {
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
