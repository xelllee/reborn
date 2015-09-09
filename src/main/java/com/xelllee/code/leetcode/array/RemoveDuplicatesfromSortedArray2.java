package com.xelllee.code.leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p/>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p/>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray2 {


    public static void main(String[] args) {


        int[] nums = {1, 1, 1, 2, 2, 3};
//        int[] nums = {1, 2, 2, 3};

        System.out.println(makeItRight(nums));


    }


    public static int makeItRight(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int size = 1;
        boolean dup = false;


        for (int i = 1; i < nums.length; i++) {

            if (!(nums[size - 1] == nums[i]) || !dup) {
                dup = (nums[size - 1] == nums[i]);
                size++;
                nums[size - 1] = nums[i];
            }
//
//            if (nums[size - 1] == nums[i]) {
//                if (!dup) {
//                    size++;
//                    dup = true;
//                }
//            } else {
//                size++;
//                dup = false;
//                nums[size - 1] = nums[i];
//            }
        }

        System.out.println(Arrays.toString(nums));
        return size;

    }

}
