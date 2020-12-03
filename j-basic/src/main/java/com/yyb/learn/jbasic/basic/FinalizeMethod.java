package com.yyb.learn.jbasic.basic;

/**
 * @description:
 * @author: Mr.Yu
 * @date: 2020-08-18 17:52
 **/
public class FinalizeMethod {
    private int item;

    public FinalizeMethod(int item) {
        this.item = item;
        System.out.println("Cake Object " + item + "is created");
    }
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalizeMethod object " + item + "is dispoed");
    }

    public static void main(String[] args) {

        FinalizeMethod f1 = new FinalizeMethod(91);
        FinalizeMethod f2 = new FinalizeMethod(92);
        FinalizeMethod f3 = new FinalizeMethod(93);
        FinalizeMethod object = null;
        for (int i = 1; i < 12; i++ ) {
            int k = i * 111;
            object = new FinalizeMethod(i * 111);
            if (999 == k) {
                f1 = f2 = null;
            }
        }

        System.gc();
    }
}
