package com.xelllee.code.leetcode.others2;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, r
 * eturn an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p/>
 * Solve it without division and in O(n).
 * <p/>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p/>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        int[] res = new int[nums.length];

        a[0] = 1;
        b[nums.length - 1] = 1;


        for (int i = 0; i < nums.length - 1; i++) {
            a[i + 1] = a[i] * nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            b[i - 1] = b[i] * nums[i];
        }


        for (int i = 0; i < nums.length; i++) {
            res[i] = a[i] * b[i];
        }

        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        result[result.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= left;
            left *= nums[i];
        }

        return result;
    }
}
