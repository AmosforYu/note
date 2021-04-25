package com.yyb.learn.jbasics.basic.algorithm.leetcode;

import com.yyb.learn.jbasics.utils.CipherUtil;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Yamos
 * @description Solution
 * @date 2021/3/29 0029 16:06
 */
public class Solution {

    /**
     * EASY-1.两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffValues = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[i]=" + nums[i]);
            System.out.println("diffValues=" + diffValues.toString());
            if (diffValues.containsKey(nums[i]) && i != diffValues.get(nums[i])) {
                return new int[]{i, diffValues.get(nums[i])};
            }
            diffValues.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * EASY-2.判断一个字符串里的所有字符是否都不同
     *
     * @param astr
     * @return
     */
    public static boolean isUnique(String astr) {
        for (int i = 0; i < astr.length() - 1; i++) {
            String cha = astr.substring(i, i + 1);
            String strEnd = astr.substring(i + 1);
            if (strEnd.contains(cha)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUnique2(String astr) {
        //& ：对应位都是1则结果为1，否则为0
        //| ：对应位都是0则结果为0，否则为1
        //^ ：对应位都相同则结果为1，否则为0
        //~ ：所有位取反，即0变为1，1变为0
        long bits = 0L;
        for (int i = 0; i < astr.length(); i++) {
            int si = astr.charAt(i) - 'A';
            if ((bits & (1L << si)) == 0) {
                bits |= (1L << si);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * EASY-3.判定两个字符串之间是否是重排关系
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (0 == s1.length() && 0 == s2.length()) {
            return true;
        }
        byte[] bytes = s1.getBytes();
        byte[] bytes2 = s2.getBytes();
        Arrays.sort(bytes);
        Arrays.sort(bytes2);
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != bytes2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * EASY-4.删除中间节点
     *
     * @param node
     */
    public static void deleteNode(ListNode node) {
        if (null == node || null == node.next) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * EASY-5.最小高度树
     *
     * @param nums 升序int数组
     * @return
     */
    public static BSTNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;

        BSTNode root = new BSTNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return root;
    }

    public static BSTNode sortedArrayToBST2(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    private static BSTNode helper(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        BSTNode root = new BSTNode(arr[mid]);
        root.left = helper(arr, left, mid - 1);
        root.right = helper(arr, mid + 1, right);

        return root;
    }

    /**
     * EASY-6.返回倒数第k个节点的值
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     *
     * @param head
     * @param k
     * @return
     */
    public static int kthToLast(ListNode head, int k) {
        int length = 1;
        ListNode curr = head;
        while (null != curr) {
            curr = curr.next;
            length++;
        }

        for (int i = 1; i < length - k; i++) {
            head = head.next;
        }

        return head.val;
    }

    public static int kthToLast2(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (null != curr) {
            list.add(curr.val);
            curr = curr.next;
        }

        return list.get(list.size() - k);
    }

    /**
     * EASY-7.返回两个数中最大的那个
     *
     * @param a
     * @param b
     * @return
     */
    public static int maximum(int a, int b) {
        long diff = (long) a - (long) b;
        int bitD = (int) (diff >> 63);

        return (bitD + 1) * a - bitD * b;
    }
    public static int maximum2(int a, int b) {//todo:
        // 先考虑没有溢出时的情况，计算 b - a 的最高位，依照题目所给提示 k = 1 时 a > b，即 b - a 为负
        int k = b - a >>> 31;
        // 再考虑 a b 异号的情况，此时无脑选是正号的数字
        int aSign = a >>> 31, bSign = b >>> 31;
        // diff = 0 时同号，diff = 1 时异号
        int diff = aSign ^ bSign;
        // 在异号，即 diff = 1 时，使之前算出的 k 无效，只考虑两个数字的正负关系
        k = k & (diff ^ 1) | bSign & diff;
        return a * k + b * (k ^ 1);
    }

    public static void main(String[] args) {

    }

    /* MEDIUM-1.两数相加 1,2,3、4,7,3,1 = 1374+321=1695*/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int ex = 0;
        while (null != l1 || null != l2) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + ex;
            if (null == head) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            ex = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (ex > 0) {
            tail.next = new ListNode(ex);
        }
        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode curr = null;
        int ex = 0;
        while (null != l1 || null != l2) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + ex;
            if (null == curr) {
                curr = new ListNode(sum % 10);
            } else {
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }
            ex = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (ex > 0) {
            curr.next = new ListNode(ex);
        }

        return curr;
    }
}
