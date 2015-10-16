package com.xelllee.code.leetcode.others;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p/>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p/>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {


    public static void main(String[] args) {


        /*
        *   0
        *   1
        *  10
        *  11
        * 100 -
        * 101
        * 110
        * */
        int[] t = {1, 0};

        System.out.println(missingNumber1(t));

    }


    public static int missingNumber1(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
