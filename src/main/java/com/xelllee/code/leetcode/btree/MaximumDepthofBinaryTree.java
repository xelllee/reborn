package com.xelllee.code.leetcode.btree;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree {


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;

    }


    public int maxDepth(TreeNode root) {
        return maxLen(root, 0);
    }

    public int maxLen(TreeNode root, int current) {
        if (root == null) return current;
        else return Math.max(maxLen(root.left, current + 1), maxLen(root.right, current + 1));

    }


}

