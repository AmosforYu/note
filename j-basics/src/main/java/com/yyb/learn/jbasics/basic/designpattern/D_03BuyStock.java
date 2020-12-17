package com.yyb.learn.jbasics.basic.designpattern;

/**
 * @author Yamos
 * @description D_03SellStock
 * @date 2020/12/17 0017 10:36
 */
public class D_03BuyStock implements D_01Order{
    private D_02Stock stock;

    public D_03BuyStock(D_02Stock stock) {
        this.stock = stock;
    }

    @Override
    public void excute() {
        stock.buy();
    }
}
