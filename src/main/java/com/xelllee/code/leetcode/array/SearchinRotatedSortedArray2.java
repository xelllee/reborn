package com.xelllee.code.leetcode.array;

import java.util.HashMap;

public class SearchinRotatedSortedArray2 {

//    Follow up for "Search in Rotated Sorted Array":
//    What if duplicates are allowed?
//
//    Would this affect the run-time complexity? How and why?
//
//    Write a function to determine if a given target is in the array.


    public static void main(String[] args) {

//        int[] nums = {4, 5, 6, 7, 12, 15, 0, 1, 2};
//        int[] nums = {1, 2, 3, 4, 5,5, 6, 7};
        int[] nums = {5, 6, 7, 1, 2, 3, 4, 5};

        System.out.println(makeItRight(nums, 5));
        System.out.println(makeItRight2(nums, 5));

    }


    public static boolean makeItRight2(int[] nums, int target) {


        return find(nums, 0, nums.length - 1, target);
    }

    public static boolean find(int[] nums, int left, int right, int target) {

        if (nums == null) return false;

        if (left > right) {
            return false;
        } else if (left < right) {
            if (nums[right] > nums[left] && (nums[left] > target || nums[right] < target)) {
                //if ordered and left greater than or right smaller than return -1
                return false;
            } else {
                //if twisted
                int mid = Math.max(left, (int) Math.floor((right - left) / 2));

                boolean leftresult = find(nums, left, mid, target);

                boolean rightresult = find(nums, mid + 1, right, target);

                return rightresult || leftresult;
            }

        } else {
            if (nums[left] == target) return true;
            else return false;
        }

    }


    public static boolean makeItRight(int[] nums, int target) {

        if (nums == null) return false;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        if (map.containsKey(target)) {
            return true;
        } else {
            return false;
        }


    }

}
