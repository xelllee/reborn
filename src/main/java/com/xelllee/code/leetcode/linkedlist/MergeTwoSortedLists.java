package com.xelllee.code.leetcode.linkedlist;

public class MergeTwoSortedLists {


    //Merge two sorted linked lists and return it as a new list.
    // The new list should be made by splicing together the nodes of the first two lists.

    public static void main(String[] args) {


    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode t1 = l1, t2 = l2;
        ListNode d = new ListNode(0);
        ListNode cur = d;

        while (t1 != null && t2 != null) {

            if (t1.val <= t2.val) {
                cur.next = t1;
                t1 = t1.next;
            } else {
                cur.next = t2;
                t2 = t2.next;
            }
            cur = cur.next;
        }

        if (t1 != null) cur.next = t1;
        if (t2 != null) cur.next = t2;

        return d.next;

    }

}
