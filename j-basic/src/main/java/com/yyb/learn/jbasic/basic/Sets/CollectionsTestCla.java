package com.yyb.learn.jbasic.basic.Sets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 集合框架源码测试
 * @author: Mr.Yu
 * @date: 2020-08-26 10:39
 **/
public class CollectionsTestCla {

    public static void main(String[] args) {
        //============LinkedList==============\\
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add("1");
        linkedList.add(false);
        linkedList.addAll( linkedList);

        linkedList.contains(false);

        linkedList.remove("1");

        Object first = linkedList.getFirst();
        linkedList.addFirst("first");
        linkedList.lastIndexOf(1);
        System.out.println("linkedList=======" + linkedList);
        //============LinkedListCla==============\\
        LinkedListCla linkedListCla = new LinkedListCla();
        linkedListCla.add(1);
        linkedListCla.add("1");
        linkedListCla.add(false);
        System.out.println("1linkedListCla====" + linkedListCla);
        linkedListCla.addAll( linkedListCla);
        System.out.println("2linkedListCla====" + linkedListCla);
        System.out.println("3linkedListCla====" + linkedListCla.contains(false));
        System.out.println("4linkedListCla====" + linkedListCla.remove("1"));
        System.out.println("5linkedListCla====" + linkedListCla.getFirst());
        try {
            linkedListCla.addFirst("first");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("6linkedListCla====" + linkedListCla.lastIndexOf(false));
        System.out.println("7linkedListCla====" + linkedListCla);

        //============ArrayList==============\\
        ArrayList arrayList = new ArrayList();

        HashMap hashMap = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

}
