package com.xelllee.code.leetcode.others2;

import com.xelllee.code.leetcode.btree.ListNode;
import com.xelllee.code.leetcode.btree.TreeNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p/>
 * You must do this in-place without altering the nodes' values.
 * <p/>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * <p/>
 * {1,2,3} - > {1,3,2}
 * <p/>
 * 3/2 = 1;
 */

public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) return;

        int n = 0;
        ListNode node = head;

        while (node != null) {
            n++;
            node = node.next;
        }

        int mid = n / 2;
        node = head;
        while (mid != 0) {
            node = node.next;
            mid--;
        }

        ListNode head2 = node.next;
        node.next = null;


        //reverse list2
        ListNode second = reverseOrder(head2);


        ListNode p1 = head;
        ListNode p2 = second;

        //merge two lists here
        while (p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;

            p1.next = p2;
            p2.next = temp1;

            p1 = temp1;
            p2 = temp2;
        }

    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode tmp, curr = head.next, prev = head;

        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        head.next = null;

        return prev;
    }

    public static ListNode reverseOrder(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        // set head node's next
        head.next = null;

        return pre;
    }


}
