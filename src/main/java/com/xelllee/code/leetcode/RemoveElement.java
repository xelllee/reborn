package com.xelllee.code.leetcode;

import java.util.Arrays;

public class RemoveElement {
//
//    Given an array and a value, remove all instances of that value in place and return the new length.
//
//    The order of elements can be changed. It doesn't matter what you leave beyond the new length.


    public static void main(String[] args) {


        int[] nums = {3, 4, 6, 7, 8, 3, 3, 6, 6, 5, 6, 6, 3};
//        int[] nums = {1};
        int val = 3;


        System.out.println(makeItRight(nums, val));

    }


    public static int makeItRight(int[] nums, int val) {


        if (nums == null) return 0;

        int l = nums.length - 1;

        int offset = 0;
        for (int i = 0; i < (l + 1 - offset); i++) {

            if (nums[i] == val) {

                while (l - offset > i && nums[l - offset] == val) {
                    offset++;
                }
                if ((l - offset) == i) {
                    offset++;
                } else {
                    nums[i] = nums[l - offset];
                    offset++;
                }
            }
        }
        return (nums.length - offset);
    }

}
