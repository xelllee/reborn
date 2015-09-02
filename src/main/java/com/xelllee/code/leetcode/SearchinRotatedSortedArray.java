package com.xelllee.code.leetcode;

import java.util.HashMap;

public class SearchinRotatedSortedArray {

//
//    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//            (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//    You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//    You may assume no duplicate exists in the array.


    public static void main(String[] args) {

//        int[] nums = {4, 5, 6, 7, 12, 15, 0, 1, 2};
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(makeItRight(nums, 1));
        System.out.println(makeItRight2(nums, 1));

    }


    public static int makeItRight2(int[] nums, int target) {


        return find(nums, 0, nums.length - 1, target);
    }

    public static int find(int[] nums, int left, int right, int target) {

        if (nums == null) return -1;

        if (left > right) {
            return -1;
        } else if (left < right) {
            if (nums[right] > nums[left] && (nums[left] > target || nums[right] < target)) {
                //if ordered and left greater than or right smaller than return -1
                return -1;
            } else {
                //if twisted
                int mid = Math.max(left, (int) Math.floor((right - left) / 2));

                int leftresult = find(nums, left, mid, target);

                int rightresult = find(nums, mid + 1, right, target);

                return (leftresult == -1) ? rightresult : leftresult;
            }

        } else {
            if (nums[left] == target) return left;
            else return -1;
        }

    }


    public static int makeItRight(int[] nums, int target) {

        if (nums == null) return -1;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        if (map.containsKey(target)) {
            return map.get(target);
        } else {
            return -1;
        }


    }

}
