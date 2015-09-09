package com.xelllee.code.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {


    /*
    *
    *   Given an array of integers, find two numbers such that they add up to a specific target number.
        The function twoSum should return indices of the two numbers such that they add up to the target,
        where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
        You may assume that each input would have exactly one solution.
    * */

    public static void main(String[] args) {


    }


    public static int[] makeItRight2(int[] nums, int target) {

        if (nums == null || nums.length < 2) return null;
//        new int[] { map.get(target - x) + 1, i + 1 };


        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff) + 1, i + 1};
            }
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                int j = map.get(diff);
                if (i != j) {
                    if (i > j) {
                        int[] arr = {j + 1, i + 1};
                        return arr;
                    } else {
                        int[] arr = {i + 1, j + 1};
                        return arr;
                    }
                }

            }

        }

        return null;

    }

    //for sorted
    public static int[] makeItRight(int[] nums, int target) {

        if (nums == null || nums.length < 2) return null;

        int[] arr = new int[2];

        Arrays.sort(nums);

        int q = 0, p = nums.length - 1;

        while (q < p) {

            int diff = target - nums[q] - nums[p];

            if (diff < 0) {
                q++;
            } else if (diff > 0) {
                p--;
            } else {
                arr[0] = q + 1;
                arr[1] = p + 1;
                return arr;
            }
        }

        return null;

    }

}
