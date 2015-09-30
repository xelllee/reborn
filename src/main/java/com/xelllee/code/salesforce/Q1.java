package com.xelllee.code.salesforce;

import java.util.Arrays;

/**
 * Given a array of integer and group size, reverse array by group size, example as follows:
 * [1, 2, 3, 4, 5, 6], 1 -> [1, 2, 3, 4, 5, 6]
 * [1, 2, 3, 4, 5, 6], 2 -> [2, 1, 4, 3, 6, 5]
 * [1, 2, 3, 4, 5, 6], 3 -> [3, 2, 1, 6, 5, 4]
 * [1, 2, 3, 4, 5, 6, 7, 8], 3 -> [3, 2, 1, 6, 5, 4, 8, 7]
 * Design test cases for you API
 */
public class Q1 {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        reverse(arr, 3);

    }

    public static void reverse(int[] arr, int size) {

        int tmp, e, j;
        for (int i = 0; i < arr.length; i++) {
            e = Math.min(size, arr.length - i);
            j = 0;
            while (j < (e / 2)) {
                tmp = arr[i];
                arr[i] = arr[i + e - j - 1];
                arr[i + e - j - 1] = tmp;
                j++;
            }
            i += e - 1;
        }

        System.out.println(Arrays.toString(arr));
    }
}
