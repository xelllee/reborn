package com.xelllee.code.leetcode.others;

import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchforaRange {


    public static void main(String[] args) {

        int[] nums = {1};


        System.out.println(Arrays.toString(searchRange(nums, 1)));

    }

    public static int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];
        int p = find(nums, 0, nums.length - 1, target);
        if (p == -1) {
            res[0] = -1;
            res[1] = -1;
        } else {
            int l = p, r = p;
            while (l >= 0 && nums[l] == target) {
                l--;
            }
            while (r < nums.length && nums[r] == target) {
                r++;
            }
            res[0] = l + 1;
            res[1] = r - 1;
        }

        return res;
    }

    public static int find(int[] nums, int s, int e, int x) {

        if (s > e) {
            return -1;
        }

        int mid = (s + e) / 2;

        if (nums[mid] == x) {
            return mid;
        } else {

            if (nums[s] <= x && nums[mid] >= x) {
                return find(nums, s, mid, x);
            } else {
                return find(nums, mid + 1, e, x);
            }
        }
    }


}
