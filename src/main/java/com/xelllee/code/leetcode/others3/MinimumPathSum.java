package com.xelllee.code.leetcode.others3;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] t = new int[m][n];
        t[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            t[i][0] = grid[i][0] + t[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            t[0][i] = grid[0][i] + t[0][i - 1];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (t[i - 1][j] <= t[i][j - 1]) {
                    t[i][j] = grid[i][j] + t[i - 1][j];
                } else {
                    t[i][j] = grid[i][j] + t[i][j - 1];
                }

            }
        }
        return t[n - 1][n - 1];
    }

    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // initialize top row
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // initialize left column
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }

        // fill up the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}
