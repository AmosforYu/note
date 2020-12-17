package com.yyb.learn.jbasics.basic.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yamos
 * @description D_04Broker 创建命令调用类
 * @date 2020/12/17 0017 10:40
 */
public class D_04Broker {
    private List<D_01Order> orderList = new ArrayList<D_01Order>();

    //[接收命令]对象的函数
    public void takeOrder(D_01Order order) {
        orderList.add(order);
    }

    //[执行命令]对象的函数
    public void placeOrders() {
        for (D_01Order order : orderList) {
            order.excute();
        }
        orderList.clear();
    }
}
