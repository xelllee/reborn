package com.xelllee.code.leetcode.linkedlist;


public class SwapNodesinPairs {

//    Given a linked list, swap every two adjacent nodes and return its head.
//
//    For example,
//    Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

    public static void main(String[] args) {
        ListNode d1 = new ListNode(2);
        ListNode d2 = new ListNode(1);
        ListNode d3 = new ListNode(3);
        d1.next = d2;
        d2.next = d3;

        ListNode t = swapPairs(d1);

        System.out.println(swapPairs(d1));


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode d = new ListNode(0);
        d.next = head;
        ListNode p = head;
        ListNode prev = d;


        while (p != null && p.next != null) {
            ListNode q = p.next, r = p.next.next;
            prev.next = q;
            q.next = p;
            p.next = r;
            prev = p;
            p = r;
        }

        return d.next;

    }

}
