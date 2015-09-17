package com.xelllee.code.leetcode.linkedlist;

public class AddTwoNumbers {

    /*
    You are given two linked lists representing two non-negative numbers.
    The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
     */
    public static void main(String[] args) {


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode d = new ListNode(0);
        ListNode p = d;
        int e = 0, s, v1, v2;

        while (l1 != null || l2 != null) {

            v1 = (l1 != null) ? l1.val : 0;
            v2 = (l2 != null) ? l2.val : 0;

            s = v1 + v2 + e;
            e = s / 10;
            p.next = new ListNode(s % 10);
            p = p.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        if (e > 0) {
            p.next = new ListNode(e);
        }

        return d.next;

    }

}
