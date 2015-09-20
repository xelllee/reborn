package com.xelllee.code.leetcode.btree;


/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;

    }


    public boolean isBalanced(TreeNode root) {

//        if (root == null) return true;
//
//        if (root.left != null && root.right != null) {
//            return isBalanced(root.left) && isBalanced(root.right);
//        } else if (root.left == null && root.right == null) {
//            return true;
//        } else if (root.left == null) {
//            return (root.right.left == null && root.right.right == null);
//        } else {
//            return (root.left.left == null && root.left.right == null);
//        }

        return maxDepth(root) != -1;

    }


    public int maxDepth(TreeNode node) {

        if (node == null) return 0;

        int L = maxDepth(node.left);
        if (L == -1) return -1;

        int R = maxDepth(node.right);
        if (R == -1) return -1;

        return Math.abs(R - L) > 1 ? -1 : Math.max(R, L) + 1;
    }

}

