package com.xelllee.code.leetcode.array;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p/>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p/>
 * For example,
 * Given input array nums = [1,1,2],
 * <p/>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray {


    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 3, 5, 6, 6, 9, 9, 19};
        System.out.println(removeDuplicates(nums));

    }


    public static int removeDuplicates(int[] arr) {

        if (arr == null || arr.length < 1) return 0;

        int size = 1;

        for (int i = 1; i < arr.length; i++) {

            if (!(arr[size - 1] == arr[i])) {
                size++;
                arr[size - 1] = arr[i];
            }
        }

//        System.out.println(size);

        return size;

    }


}
