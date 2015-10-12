package com.xelllee.code.sf;

import com.xelllee.code.leetcode.btree.TreeNode;


/**
 * write program to mirror the binary tree.
 */
public class Q3 {

    public static void main(String[] args) {


    }


    public static void cloneTree(TreeNode root, TreeNode left, TreeNode right) {


        if (left != null) {
            TreeNode leftnode = new TreeNode(left.val);
            root.right = leftnode;
            cloneTree(leftnode, left.left, left.right);
        }

        if (right != null) {
            TreeNode rightnode = new TreeNode(right.val);
            root.left = rightnode;
            cloneTree(rightnode, right.left, right.right);
        }

    }


    private static TreeNode last = null;


    public static void inOrder(TreeNode root) {

        if (last == null) {


        } else {

        }


    }
}
