package com.xelllee.code.leetcode.others2;

import com.xelllee.code.leetcode.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p/>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) return lists;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        build(stack, lists, false);

        return lists;
    }


    public static void build(Stack<TreeNode> stack, List<List<Integer>> lists, boolean inorder) {

        if (stack.isEmpty()) return;

        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> nStack = new Stack<TreeNode>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (inorder) {
                if (node.left != null)
                    nStack.push(node.left);
                if (node.right != null)
                    nStack.push(node.right);
            } else {
                if (node.right != null)
                    nStack.push(node.right);
                if (node.left != null)
                    nStack.push(node.left);
            }
        }
        lists.add(list);
        build(nStack, lists, !inorder);
    }

}
