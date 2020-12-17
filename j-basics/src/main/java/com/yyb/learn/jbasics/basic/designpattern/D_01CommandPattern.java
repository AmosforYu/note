package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @author Yamos
 * @description D_CommandPattern 命令模式
 *  命令模式的要点：
 *  1.命令模式将发出请求的对象[被执行者/调用者]和执行请求的对象[执行者/接收者]解耦；
 *  2.被解耦的两者之间是通过命令对象进行沟通的。命令对象封装了调用者和一个或一组动作；
 *  3.调用者通过调用命令对象的execute()方法发出请求，这会使得接收者的动作被调用；
 *  4.调用者可以接受命令当作参数，甚至在运行时动态地进行；
 *  5.命令可以支持撤销，做法是实现一个undo()方法来回到execute()方法被执行前的状态；
 * @date 2020/12/17 0017 9:45
 */
public class D_01CommandPattern {
    //5.使用命令调用类来[接收]并[执行]命令
//    public static void main(String[] args) {
//        //命令调用方(被执行者) //CellingLight
//        D_02Stock adStock = new D_02Stock("yyb", 33);
//
//        //命令集 //LightOnCommand
//        D_03BuyStock buyStock = new D_03BuyStock(adStock);
//        D_03SellStock sellStock = new D_03SellStock(adStock);
//
//        //命令执行者 //RemoteControl
//        D_04Broker broker = new D_04Broker();
//        broker.takeOrder(buyStock);
//        broker.takeOrder(sellStock);
//
//        broker.placeOrders();
//    }
}
