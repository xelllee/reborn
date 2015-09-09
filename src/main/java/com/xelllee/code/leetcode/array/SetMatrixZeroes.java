package com.xelllee.code.leetcode.array;

import java.util.Arrays;

public class SetMatrixZeroes {


//    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//    click to show follow up.


//    Follow up:
//    Did you use extra space?
//    A straight forward solution using O(mn) space is probably a bad idea.
//    A simple improvement uses O(m + n) space, but still not the best solution.
//    Could you devise a constant space solution?

    public static void main(String[] args) {

        int[][] matrix = {{1, 1, 0},
                {2, 0, 2},
                {1, 2, 2}};

        makeItRight(matrix);


    }


    //clumzy code
    public static void makeItRight(int[][] matrix) {


        if (matrix == null) return;

        for (int i = 0; i < matrix.length; i++) {

            int m = matrix.length;
            int n = matrix[i].length;

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 0) continue;

                boolean flag = false;

                for (int t = 0; t < m; t++) {
                    if (matrix[t][j] == 0) {
                        flag = true;
                    }
                }

                if (!flag) {
                    for (int t = 0; t < n; t++) {
                        if (matrix[i][t] == 0) {
                            flag = true;
                        }
                    }
                }

                if (flag) {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = (matrix[i][j] > 0) ? matrix[i][j] : (matrix[i][j] != Integer.MIN_VALUE) ? matrix[i][j] - 1 : matrix[i][j];
                }

            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0 && matrix[i][j] != Integer.MIN_VALUE) matrix[i][j] = matrix[i][j] + 1;
            }
        }


        for (int[] arr : matrix) {
            System.out.print(Arrays.toString(arr));
        }

    }


}
