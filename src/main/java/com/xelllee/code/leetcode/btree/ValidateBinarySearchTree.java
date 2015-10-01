package com.xelllee.code.leetcode.btree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Question:
 * Given a binary tree, determine if it is a valid Binary Search Tree (BST).
 * Solution:
 */
public class ValidateBinarySearchTree {


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;

    }


    private static TreeNode prev = null;

    public static boolean isBST(TreeNode n, Integer l, Integer r) {

        if (n == null) return true;
        return (((l == null) || (n.val > l)) && ((r == null) || (n.val < r)))
                && isBST(n.left, l, n.val) && isBST(n.right, n.val, r);
    }


    public static boolean isBST(TreeNode n) {
        return inOrder(n);
    }


    public static boolean inOrder(TreeNode node) {

        if (node == null) return true;

        if (inOrder(node.left)) {

            if (prev != null && prev.val <= node.val) return false;

            prev = node;

            return inOrder(node.right);
        }
        return false;
    }


}

