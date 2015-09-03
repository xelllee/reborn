package com.xelllee.code.leetcode;

import java.util.*;

public class LongestConsecutiveSequence {


//    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//    For example,
//    Given [100, 4, 200, 1, 3, 2],
//    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//    Your algorithm should run in O(n) complexity.


    public static void main(String[] args) {


        int[] nums = {100, 4, 200, 1, 3, 5, 2, 9, 10, 11, 12, 15, 17, 14, 13, 16};
//        int[] nums1 = {1, 1000, 7, 8, 9, 10};

        System.out.println(makeItRight(nums));
        System.out.println(makeItRight2(nums));

    }


    //better
    public static int makeItRight2(int[] nums) {

        if (nums == null) return 0;

        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> done = new HashSet<Integer>();
        int max_count = 0;


        for (int num : nums) {
            set.add(num);
        }

        int counter = 1;
        for (int num : set) {

            if (done.contains(num)) continue;

            int down = num - 1;
            int up = num + 1;

            while (set.contains(down)) {
                done.add(down);
                counter++;
                down--;
            }

            while (set.contains(up)) {
                done.add(up);
                counter++;
                up++;
            }
            max_count = Math.max(max_count, counter);
            counter = 1;
        }


        return max_count;

    }


    //bad
    public static int makeItRight(int[] nums) {


        HashSet<Integer> set = new HashSet<Integer>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int max_count = 0;


        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }


        int counter = 0;
        for (int i = min; i < max; i++) {
            if (set.contains(i)) {
                counter++;
            } else {
                max_count = Math.max(counter, max_count);
                counter = 0;
            }
        }
        return max_count;

    }

}
