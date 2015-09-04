package com.xelllee.code.leetcode;

import java.util.*;

public class ThreeSumClosest {

//    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
//    Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//    For example, given array S = {-1 2 1 -4}, and target = 1.
//
//    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//


    public static void main(String[] args) {

//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
//        int[] nums = {13, 11, -3, -1, 6, -11, -11, -12, 1, -11, -10, 12, 3, -11, 0, 9, 3, -13, -10, -2, 6, 14, 9, -4, -9, -3, -9, -15, -10, 4, -7, 10, 1, -3, -5, 14, 1, -9, -13, -12, -4, -8, 7, 6, -4, -8, 0, 6, -14, -3, -11, 0, -4, 13, 3, 2, -13, 9, 2, 14, -1, 10, 10, 7, 14, 12, 6, 0, -12, 0, -5, -9, 7, -13, 12, 10, -13, -3, 1, 10, 9, 5, -5, 12, -5, 13, -1, -11, 0, -14, -11, 6, 3, 14, -2, 2, 11, 11, 10, 6, -4, 12, 13, 10, 7, 10, 5, 1};


        System.out.println(makeItRight(nums, target));

    }


    //
    public static int makeItRight(int[] nums, int target) {

        if (nums == null || nums.length < 3) return 0;


        Arrays.sort(nums);

        int sum = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int p = i + 1, q = nums.length - 1;

            while (p < q) {

                int tmpsum = nums[i] + nums[p] + nums[q];


                if (tmpsum < target) {

                    int tmpdiff = Math.abs(target - tmpsum);
                    if (tmpdiff < diff) {
                        diff = tmpdiff;
                        sum = tmpsum;
                    }

                    p++;

                } else if (tmpsum > target) {

                    int tmpdiff = Math.abs(target - tmpsum);
                    if (tmpdiff < diff) {
                        diff = tmpdiff;
                        sum = tmpsum;
                    }

                    q--;
                } else {
                    // ==
                    return target;
                }

            }

        }

        return sum;
    }


}
