package com.xelllee.code.leetcode.misc;

import java.util.ArrayList;

public class SpiralMatrix {
//
//    Question:
//    Given a matrix of m ✕n elements (m rows, n columns) matrix[m][n], return all elements of the matrix in spiral order.
//    For example, given the following matrix:
//            [1]
    //[1]
    /*      [ 7, 8, 9 ]
    [       [ 4, 5, 6 ],
            [ 1, 2, 3 ],
            ]
         */

//
      /*     [1,2,3]
      *      [3,4,3]
      *      [5,6,3]
      *      [7,8,3]
      * */
    //3x3
//
//            ]
//    You should return [1,2,3,6,9,8,7,4,5].

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};


        makeItRight(arr);
    }


    public static ArrayList<Integer> makeItRight(int[][] nums) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return list;

        int m = nums.length;
        int n = nums[0].length;

        int way = 0, counter = 0, start = 0;

        int mp = start, np = start;

        while (true) {

            if (counter == m * n)
                break;
            else
                list.add(nums[mp][np]);

            if (way == 0) {
                if (np < (n - 1 - start)) {
                    np++;
                } else {
                    way = 1;
                    mp++;
                }
            } else if (way == 1) {
                if (mp < (m - 1 - start)) {
                    mp++;
                } else {
                    way = 2;
                    np--;
                }
            } else if (way == 2) {
                if (np > start) {
                    np--;
                } else {
                    way = 3;
                    mp--;
                }
            } else {
                if (mp > (start + 1)) {
                    mp--;
                } else {
                    way = 0;
                    np++;
                    start = np;
                }
            }
            counter++;
        }
        return list;
    }


}
