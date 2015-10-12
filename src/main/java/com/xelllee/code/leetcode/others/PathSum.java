package com.xelllee.code.leetcode.others;

import com.xelllee.code.leetcode.btree.TreeNode;

/**
 * Created by xiao on 10/11/15.
 */
public class PathSum {

    //



    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && (root.left == null && root.right == null))
            return true;

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
