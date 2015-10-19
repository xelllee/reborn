package com.xelllee.code.leetcode.others2;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2,  6 7 0 1 2 4 5, 2 4 5 6 7 0 1 , 5 6 7 0 1 2 4 ).
 * <p/>
 * Find the minimum element.
 * <p/>
 * You may assume no duplicate exists in the array.
 */
public class FindMinimuminRotatedSortedArray {


    public static void main(String[] args) {
//        int[] nums = {  0, 1, 2,4,5, 6, 7,};
        int[] nums = {7, 8, 9, 3, 4};


        System.out.println(findMin(nums));
    }


    public static int findMin(int[] nums) {

        return find(nums, 0, nums.length - 1, Integer.MAX_VALUE);
    }


    public static int find(int[] arr, int s, int e, int min) {

        if (e < s) return Integer.MAX_VALUE;

        if (arr[e] >= arr[s]) return Math.min(min, arr[s]);

        if (e - s == 1) return Math.min(min, Math.min(arr[e], arr[s]));

        int mid = (s + e) / 2;

        min = Math.min(min, arr[mid]);

        if (arr[s] >= arr[mid] && arr[mid - 1] <= arr[mid]) {
            return Math.min(min, find(arr, s, mid - 1, min));
        } else {
            return Math.min(min, find(arr, mid + 1, e, min));
        }
    }

    public int findMin(int[] num, int left, int right) {
        if (left == right)
            return num[left];
        if ((right - left) == 1)
            return Math.min(num[left], num[right]);

        int middle = left + (right - left) / 2;

        // not rotated
        if (num[left] < num[right]) {
            return num[left];

            // go right side
        } else if (num[middle] > num[left]) {
            return findMin(num, middle, right);

            // go left side
        } else {
            return findMin(num, left, middle);
        }
    }


}
