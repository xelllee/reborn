package com.xelllee.code.leetcode.others2;

import com.xelllee.code.leetcode.btree.ListNode;
import com.xelllee.code.leetcode.btree.TreeNode;

import java.util.ArrayList;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {


    public static void main(String[] args) {

        ListNode n = new ListNode(1);
        ListNode n1 = new ListNode(3);
        n.next = n1;

        sortedListToBST(n);
    }

    public static TreeNode sortedListToBST(ListNode head) {


        if (head == null) return null;

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(head.val);

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            list.add(node.val);
        }

        return build1(list, 0, list.size() - 1);

    }


    public static TreeNode build1(ArrayList<Integer> list, int s, int e) {


        if (e < s) {
            return null;
        }

        int mid = (s + e) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        TreeNode left = build1(list, s, mid - 1);
        TreeNode right = build1(list, mid + 1, e);

        root.left = left;
        root.right = right;


        return root;
    }
}
