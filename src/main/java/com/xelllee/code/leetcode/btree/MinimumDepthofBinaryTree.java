package com.xelllee.code.leetcode.btree;

import java.util.Stack;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Similar to Question [26. Maximum Depth of Binary Tree], here we need to find the minimum depth instead.
 */
public class MinimumDepthofBinaryTree {


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;

    }


    private int sum = 0;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        return breath(stack, 0);
    }

    public int breath(Stack<TreeNode> c, int sum) {

        Stack<TreeNode> n = new Stack<TreeNode>();
        while (!c.isEmpty()) {
            TreeNode node = c.pop();
            if (node == null) continue;
            if (node.left == null && node.right == null) return sum + 1;
            else {
                n.push(node.left);
                n.push(node.right);
            }
        }
        return breath(n, sum + 1);
    }


}

