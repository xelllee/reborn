package com.xelllee.code.leetcode.btree;


import java.util.HashMap;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree. For example, given the below binary tree,
 * 1 /\ 24
 * /\ 23
 * The highlighted path yields the maximum sum 10.
 * <p/>
 * <p/>
 * Given a binary tree, find the maximum path sum.
 * <p/>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path does not need to go through the root.
 * <p/>
 * For example:
 * Given the below binary tree,
 * <p/>
 * 1
 * / \
 * 2   3
 * Return 6.
 */

//TODO:
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;


        int[] left = {2, 1, -3, 4, -1, 2, 1, -5, 4};

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        maxsum(left, 0, left.length - 1, map);
        System.out.println(maxsum);


    }

    private static int maxsum = Integer.MIN_VALUE;


    //DnC


    private static int maxsum(TreeNode node) {

        if (node == null) return 0;

        int l = maxsum(node.left);
        int r = maxsum(node.right);

        maxsum = Math.max(node.val + l + r, maxsum);

        int ret = Math.max((node.val + l), (node.val + r));

        return (ret > 0) ? ret : 0;
    }

    public static int maxsum(int[] arr, int s, int e, HashMap<String, Integer> map) {

        if (s > e) return 0;

        String k = s + "+" + e;
        int sum, tmp;

        if (map.containsKey(k)) {
            sum = map.get(k);
        } else {
            tmp = maxsum(arr, s + 1, e, map);
            sum = Math.max(arr[s] + tmp, 0);
            maxsum = Math.max(sum, maxsum);

        }
        map.put(k, sum);
        return sum;

    }


}

