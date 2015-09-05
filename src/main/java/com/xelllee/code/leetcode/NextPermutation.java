package com.xelllee.code.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {


//
//    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//    The replacement must be in-place, do not allocate extra memory.
//
//    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//            1,2,3 → 1,3,2
//            3,2,1 → 1,2,3
//            1,1,5 → 1,5,1

    // 1,1,2, 1,2,1        1,3,4,2  1,4,2,3 |

    public static void main(String[] args) {


        int[] nums = {1, 3, 2};        // {1,2,1} -> {2,1,1}
//        Arrays.sort(nums);
//        Arrays.sort(nums, 0, 3);
//        partialSort(nums, 1, 3);
//        System.out.println(Arrays.toString(nums));
        makeItRight(nums);


    }


    public static void makeItRight(int[] nums) {

        if (nums == null) return;

        int len = (nums.length - 1);
        int i = 0;
        while ((len - i) > 0) {

            int cur = (len - i - 1);

            for (int t = 0; t <= i; t++) {

                if (nums[len - t] > nums[cur]) {
                    int tmp = nums[len - t];
                    nums[len - t] = nums[cur];
                    nums[cur] = tmp;
                    Arrays.sort(nums, len - i, len + 1);
                    System.out.println(Arrays.toString(nums));

                    return;
                }
            }
            i++;
        }

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
    }


}
