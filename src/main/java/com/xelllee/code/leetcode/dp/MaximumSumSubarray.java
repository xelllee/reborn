package com.xelllee.code.leetcode.dp;


import java.util.HashMap;

public class MaximumSumSubarray {

/*

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

* */

    static int sum = 0;

    public static void main(String[] args) {

//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] arr = {-57, 9, -72, -72, -62, 45, -97, 24, -39, 35, -82, -4, -63,
                1, -93, 42, 44, 1, -75, -25, -87, -16, 9};

//        System.out.println(arr);
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray2(arr));

    }

    public static int maxSubArray(int[] nums) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        maxSum(nums, 0, nums.length - 1, map);
        return sum;
    }


    public static int maxSum(int[] nums, int s, int e, HashMap<String, Integer> map) {

        String key = s + "+" + e;
        int tmp = 0;
        if (map.containsKey(key)) {
            tmp = map.get(key);
        } else if (s == e) {
            tmp = nums[e];
        } else if (e - s > 0) {
            tmp = nums[s] + maxSum(nums, s + 1, e, map);
        }
        tmp = Math.max(0, tmp);
        map.put(key, tmp);
        sum = Math.max(sum, tmp);
        return tmp;

    }

    public static int maxSubArray2(int[] A) {
        int maxEndingHere = A[0], maxSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }

}
