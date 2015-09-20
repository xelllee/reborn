package com.xelllee.code.leetcode.btree;

/**
 * Created by xiao on 9/16/15.
 */
public class TreeNode {

    public TreeNode left = null;
    public TreeNode right = null;

    public int val;

    public TreeNode(int v) {
        val = v;
    }

    public boolean hasChild() {
        return (left != null) || (right != null);
    }

}
