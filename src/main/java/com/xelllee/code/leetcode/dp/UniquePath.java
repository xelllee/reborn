package com.xelllee.code.leetcode.dp;


public class UniquePath {

/*

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

[] []
[] []
* */

    public static void main(String[] args) {

        int[][] arr = new int[2][2];

        System.out.println(arr[1][1]);

        System.out.println(uniquePaths(21, 14));
    }


    public static int uniquePaths(int m, int n) {

        int[][] arr = new int[m + 1][n + 1];
        return count(m, n, arr);
    }


    //top-down
    public static int count(int m, int n, int[][] arr) {

        int count = 0;
        if (arr[m][n] != 0) {
            count = arr[m][n];
        } else if (m <= 1 && n <= 1) {
            count = 0;
        } else if (m == 1 || n == 1) {
            count = 1;
        } else if (m > 1 && n > 1) {
            count = count(m - 1, n, arr) + count(m, n - 1, arr);
        }
        arr[m][n] = count;
        return count;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;


        return 1;
    }


}
