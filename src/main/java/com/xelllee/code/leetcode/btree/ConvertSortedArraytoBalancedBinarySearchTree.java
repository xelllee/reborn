package com.xelllee.code.leetcode.btree;


/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than 1.
 */

//TODO:
public class ConvertSortedArraytoBalancedBinarySearchTree {


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;


        int[] left = {1, 2, 3, 4, 5, 6};


    }


    //DnC

    public static TreeNode toBtree(int[] arr, int start, int end) {

        if (start > end) return null;
        int mid = ((end - start) / 2 + start);

        TreeNode p = new TreeNode(arr[mid]);

        p.left = toBtree(arr, start, mid -1);
        p.right = toBtree(arr, mid + 1, end);

        return p;

    }


}

