package com.xelllee.code.leetcode.others2;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p/>
 * You may assume no duplicates in the array.
 * <p/>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {


    public static void main(String[] args) {

        int[] t = {1, 3};

        System.out.println(searchInsert(t, 2));

    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return (nums[0] >= target) ? 0 : 1;
        return find(nums, 0, nums.length - 1, target);
    }


    public static int find(int[] nums, int s, int e, int x) {

        if (s > e) return s - 1;
        int mid = (s + e) / 2;
        if (nums[mid] == x) return mid;
        else if (nums[s] <= x && x <= nums[mid]) {
            return find(nums, s, mid, x);
        } else if (x >= nums[mid + 1] && x <= nums[e]) {
            return find(nums, mid + 1, e, x);
        } else {
            return (x < nums[0]) ? 0 : nums.length;
        }
    }
}
