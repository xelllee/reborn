package com.xelllee.code.leetcode;

import java.util.Arrays;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p/>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p/>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p/>
 * 1234,1243,1324,1342,     1,2,3,4,5,6,7,8
 * <p/>
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {


    //TODO: see you later...
    public static void main(String[] args) {

//        System.out.println(Math.pow(2, 4));

//        System.out.print(Integer.toBinaryString(8));


        System.out.println(makeItRight(5, 5));
        //4*3*2*1 =

    }


    public static String makeItRight(int n, int k) {


        int total = 1;
        int index = -1, offset = 0;
        int[] nums = new int[n];

        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
            total *= i;

            if ((total - k) > 0 || index != -1) {
                index = i - 1;
            }
            offset = (index == -1) ? Math.abs(total - k) : offset;
        }


        if (total < k) return "...";


        int counter = 1;
        int p = n - 1;
        while (p > 0) {


            if (counter == k) {

            }

            counter++;
            p--;
        }


        return "...";

    }

}
