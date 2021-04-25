package com.yyb.learn.jbasics.basic.algorithm.leetcode;

/**
 * 单向链表节点
 * @author Yamos
 * @description ListNode
 * @date 2021/3/29 0029 17:32
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
