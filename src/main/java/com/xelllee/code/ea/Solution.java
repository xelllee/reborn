package com.xelllee.code.ea;

/**
 * ## Input
 * Input of the program should be a txt file,
 * {5, 6, -3, 8, -9, 2},
 * {1, -12, 20, 0, -3, -5},
 * {-9, -7, -3, 6, 7, -1},
 * First line is the column number and row number of the matrix.
 * ## Output
 * Output of the program should in standard output,
 * Sum: 28
 * TopLeftIndex: 0, 2
 * BottomRightIndex: 2, 3
 * <p/>
 * <p/>
 * Solution :
 * We will create a same sized matrix to keep the vertical sum of the original matrix. For example verticalSum[i,j]=arr[0,j]+arr[1,j]+...+arr[i,j].
 * Now we will take the row range and move from left to right to find the maximum sum. There are O(n^2) row range possible. Row range will be a range from rowStart to rowEnd.
 * Both of these variables can vary from 1 to n. So there are O(n^2) rowRange possible.  For any starting row we start with one row and move from left to right.
 * Then we take 2 rows and move from left to right. While doing so, we maintain an array sum which maintains the vertical sum of the selected row range.
 * This sum array and vertical sum matrix will help us find the sum for a new sub matrix in O(1) time.  So the total time complexity will be O(n^3). O(n^2) for row range,
 * and we will have a O(column) operation inside that. So the total complexity will become O(n^3).
 * <p/>
 * 1,
 */
public class Solution {

    public static void main(String[] args) {


        int[][] arr =
                {
                        {5, 6, -3, 8, -9, 2},
                        {1, -12, 20, 0, -3, -5},
                        {-9, -7, -3, 6, 7, -1},
                };
        int[] leftRightTopBottom = new int[4];
        int maxsum = findMaximumSumSubMatrix(arr, leftRightTopBottom);
        System.out.println("max sum: " + maxsum);
        System.out.println("indices left right top bottom");
        for (int index : leftRightTopBottom)
            System.out.print(index + ",");
    }

    private static int findMaximumSumSubMatrix(int[][] arr, int[] leftTopRightBottom) {

        leftTopRightBottom[0] = 0;
        leftTopRightBottom[1] = 0;
        leftTopRightBottom[2] = 0;
        leftTopRightBottom[3] = 0;
        int rows = arr.length;
        int cols = arr[0].length;
        int[] sum = new int[cols];
        int[] pos = new int[cols];
        int localMax;
        int maxSum = arr[0][0];
        int[][] colsSum = new int[rows][cols];

        for (int iRow = 0; iRow < rows; iRow++) {
            for (int jCol = 0; jCol < cols; jCol++) {
                if (iRow == 0) {
                    colsSum[iRow][jCol] = arr[iRow][jCol];
                } else {
                    colsSum[iRow][jCol] = arr[iRow][jCol] + colsSum[iRow - 1][jCol];
                }
            }
        }

        for (int iRow = 0; iRow < rows; iRow++) {
            for (int k = iRow; k < rows; k++) {

                for (int index = 0; index < cols; index++) {
                    sum[index] = 0;
                    pos[index] = 0;
                }
                localMax = 0;
                int tmp = 0;
                if (iRow > 0) {
                    tmp = colsSum[iRow - 1][0];
                }
                sum[0] = colsSum[k][0] - tmp;
                for (int j = 1; j < cols*2; j++) {

                    tmp = 0;
                    if (iRow > 0) {
                        tmp = colsSum[iRow - 1][j];
                    }
                    if (sum[j - 1] > 0) {
                        sum[j] = sum[j - 1] + colsSum[k][j] - tmp;
                        pos[j] = pos[j - 1];
                    } else {
                        sum[j] = colsSum[k][j] - tmp;
                        pos[j] = j;
                    }
                    if (sum[j] > sum[localMax]) {
                        localMax = j;
                    }
                }
                if (sum[localMax] > maxSum) {
                    maxSum = sum[localMax];
                    leftTopRightBottom[0] = pos[localMax];
                    leftTopRightBottom[1] = localMax;
                    leftTopRightBottom[2] = iRow;
                    leftTopRightBottom[3] = k;
                }
            }
        }
        return maxSum;
    }


}


