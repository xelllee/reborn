package com.xelllee.code.leetcode.dp;


import java.util.HashMap;

public class UniquePath {

/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid
(marked 'Finish' in the diagram below).

How many possible unique paths are there?


http://leetcode.com/wp-content/uploads/2014/12/robot_maze.png
Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

[] []
[] []
* */

    public static void main(String[] args) {

        int[][] arr = new int[2][2];

        System.out.println(arr[1][1]);

        System.out.println(uniquePaths(21, 14));
        System.out.println(uniquePaths2(21, 14));
        System.out.println(uniquePaths3(21, 14));
    }


    public static int uniquePaths3(int m, int n) {

        int[][] arr = new int[m + 1][n + 1];
        return count2(m, n, arr);
    }

    public static int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        return count(m, n, map);
    }


    //top-down
    public static int count2(int m, int n, int[][] arr) {

        int count = 0;
        if (arr[m][n] != 0) {
            count = arr[m][n];
        } else if (m <= 1 && n <= 1) {
            count = 0;
        } else if (m == 1 || n == 1) {
            count = 1;
        } else if (m > 1 && n > 1) {
            count = count2(m - 1, n, arr) + count2(m, n - 1, arr);
        }
        arr[m][n] = count;
        return count;
    }

    //top-down
    public static int count(int m, int n, HashMap<String, Integer> map) {

        int count = 0;
        String key = m + "+" + n;     //112 - > 1,12/ 11,2

        if (map.containsKey(key)) {
            count = map.get(key);
        } else if (m <= 1 && n <= 1) {
            count = 0;
        } else if (m == 1 || n == 1) {
            count = 1;
        } else if (m > 1 && n > 1) {
            count = count(m - 1, n, map) + count(m, n - 1, map);
        }
        map.put(key, count);
        return count;
    }


    public static int uniquePaths2(int m, int n) {
        int[][] mat = new int[m + 1][n + 1];
        mat[m - 1][n] = 1;
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                mat[r][c] = mat[r + 1][c] + mat[r][c + 1];
            }
        }
        return mat[0][0];
    }


}
