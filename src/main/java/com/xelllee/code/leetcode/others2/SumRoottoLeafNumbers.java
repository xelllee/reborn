package com.xelllee.code.leetcode.others2;

import com.xelllee.code.leetcode.btree.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p/>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p/>
 * Find the total sum of all root-to-leaf numbers.
 * <p/>
 * For example,
 * <p/>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p/>
 * Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers {


    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(6);
        n1.left = n3;
        n1.right = n2;
        n2.right = n4;

        System.out.println(sumNumbers(n1));

    }

    public static int sumNumbers(TreeNode root) {

        if (root == null) return 0;

        else return sum(root, new StringBuilder(), 0);
    }


    public static int sum(TreeNode node, StringBuilder sb, int sum) {

        int sumr = 0, suml = 0;
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            return Integer.parseInt(sb.toString());
        } else {
            if (node.left != null) {
                StringBuilder newsb = new StringBuilder(sb);
                suml += sum(node.left, newsb, suml);
            }
            if (node.right != null) {
                StringBuilder newsb = new StringBuilder(sb);
                sumr += sum(node.right, newsb, sumr);
            }
        }
        return sumr + suml;
    }
}

