package com.xelllee.code.leetcode.array;

import java.util.Arrays;

public class RotateImage {

    //    You are given an n x n 2D matrix representing an image.
    //    Rotate the image by 90 degrees (clockwise).
    //    Follow up:
    //    Could you do this in-place?

    /*  {4, 4, 4, 4}     {1, 2, 3, 4}
        {3, 3, 3, 3}     {1, 2, 3, 4}           2,1 -> 1,1
        {2, 2, [2], 2}   {1, [2], 3, 4}         3,1 ->
        {1, 1, 1, 1}     {1, 2, 3, 4}

                                                          1,2   3,1
    [[1,2],[3,4]]    [[3,1],[4,2]]                        3,4   4,2

     {3,4}  {1,3}   {1,2}      [4,2]
     {1,2}  {2,4}   {3,4}      [3,1]

   * */

    public static void main(String[] args) {

//        int[][] matrix = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        int[][] matrix = {{1, 2}, {3, 4}};
        //[[3,1],[4,2]]

//        makeItRight(matrix);
//        makeItRight2(matrix);
        makeItRight3(matrix);

    }


    public static void makeItRight3(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        // matrix[i][j]<->matrix[j][i]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    int tem = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tem;
                }
            }
        } //matrix[i][j]<->matrix[m-1-i][j]
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++)

            {
                int tem = matrix[j][i];
                matrix[j][i] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tem;
            }
        }
        for (int[] arr : matrix) {
            System.out.print(Arrays.toString(arr));
        }
    }

    //in place
    public static void makeItRight2(int[][] matrix) {

        if (matrix == null) return;

        int n = matrix.length;
        //  x = y,  y = (n-x)

        int tmp;
        int counter = 1;
        int finish = n * n;

        int x = 0, newx;
        int y = 0, newy;
        int lastv = matrix[0][0];
        int circle = 0;


        while (counter <= finish) {

            newx = y;
            newy = ((n - 1) - x);

            tmp = matrix[newy][newx];
            matrix[newy][newx] = lastv;
//            System.out.println(x + "," + y + ":" + newx + "," + newy + ": lastv," + lastv + ": this," + tmp + ": counter," + counter);

            lastv = tmp;
            x = newx;
            y = newy;

            if ((counter % 4) == 0) {
                if (y < ((n - 1) - 1 - circle)) {
                    y++;
                } else {
                    circle++;
                    x = circle;
                    y = circle;
                }

                lastv = matrix[y][x];
            }

            counter++;
        }

        for (int[] arr : matrix) {
            System.out.print(Arrays.toString(arr));
        }

    }

    public static void makeItRight(int[][] matrix) {

        if (matrix == null) return;

        int n = matrix.length;
        int[][] swapped = new int[n][n];
        //  x = y,  y = (n-x)

        //i/y j/x   -> x =i , y = n -j
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                swapped[n - 1 - j][i] = matrix[i][j];
            }
        }

        for (int[] arr : swapped) {
            System.out.print(Arrays.toString(arr));
        }
    }

}
