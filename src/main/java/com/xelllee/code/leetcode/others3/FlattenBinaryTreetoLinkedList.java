package com.xelllee.code.leetcode.others3;

import com.xelllee.code.leetcode.btree.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p/>
 * For example,
 * Given
 * <p/>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class FlattenBinaryTreetoLinkedList {


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        TreeNode fake = new TreeNode(-1);
        flatten(node1, fake);


    }

    //this is better in term of space?
    public static void flatten(TreeNode root, TreeNode prev) {

        if (root != null) {
            TreeNode rightNode = root.right;
            prev.right = root;
            prev = root;
            if (root.left != null) flatten(root.left, prev);
            root.left = null;
            if (rightNode != null) flatten(rightNode, prev);
        }
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while(p != null || !stack.empty()){

            if(p.right != null){
                stack.push(p.right);
            }

            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                p.right=temp;
            }

            p = p.right;
        }
    }
}
