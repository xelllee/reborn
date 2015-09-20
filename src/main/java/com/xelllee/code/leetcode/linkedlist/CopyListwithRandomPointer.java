package com.xelllee.code.leetcode.linkedlist;


public class CopyListwithRandomPointer {

    //TODO:
//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

    public static void main(String[] args) {
        ListNode d1 = new ListNode(2);
        ListNode d2 = new ListNode(1);
        ListNode d3 = new ListNode(3);
        d1.next = d2;
        d2.next = d3;


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {


        ListNode d = new ListNode(0);


        return d.next;

    }

}
