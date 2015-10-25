package com.xelllee.code.leetcode.others2;

import com.xelllee.code.leetcode.btree.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {


    public static void main(String[] args) {

        int[] t = {1, 3, 0, 6, 7};
        Arrays.sort(t);
        System.out.println(Arrays.toString(t));
    }

    public static ListNode sortList(ListNode head) {

        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }

        ListNode[] nodes = breakList(node, n);

        return mergeSort(nodes[0], n / 2, nodes[1], n - n / 2);


    }

    public static ListNode mergeSort(ListNode node1, int n1, ListNode node2, int n2) {

        if (n1 <= 2 && n2 <= 2) {
            node1 = orderNode(node1);
            node2 = orderNode(node2);
        } else {
            ListNode[] nodes1 = breakList(node1, n1);
            node1 = mergeSort(nodes1[0], n1 / 2, nodes1[1], n1 - n1 / 2);
            ListNode[] nodes2 = breakList(node2, n2);
            node2 = mergeSort(nodes2[0], n1 / 2, nodes2[1], n2 - n2 / 2);
        }


        return mergeTwoLists(node1, node2);

    }

    public static ListNode mergeTwoLists(ListNode leftlist, ListNode rightlist) {
        if (rightlist == null)
            return leftlist;
        if (leftlist == null)
            return rightlist;

        ListNode fakehead = new ListNode(-1);
        ListNode ptr = fakehead;
        while (rightlist != null && leftlist != null) {
            if (rightlist.val < leftlist.val) {
                ptr.next = rightlist;
                ptr = ptr.next;
                rightlist = rightlist.next;
            } else {
                ptr.next = leftlist;
                ptr = ptr.next;
                leftlist = leftlist.next;
            }
        }

        if (rightlist != null)
            ptr.next = rightlist;
        if (leftlist != null)
            ptr.next = leftlist;

        return fakehead.next;
    }

    public static ListNode[] breakList(ListNode node, int n) {

        ListNode[] nodes = new ListNode[2];
        nodes[0] = node;
        ListNode tmp = node.next;
        ListNode prev = node;

        int mid = n / 2 - 1;

        while (mid != 0) {
            tmp = tmp.next;
            prev = prev.next;
            mid--;
        }
        prev.next = null;
        nodes[1] = tmp;

        return nodes;

    }


    public static ListNode orderNode(ListNode node) {

        if (node.next == null) return node;

        else {
            if (node.val >= node.next.val) {
                node.next = null;
                return node;
            } else {
                ListNode newHead = node.next;
                node.next = null;
                newHead.next = node;
                return newHead;
            }
        }
    }


}
