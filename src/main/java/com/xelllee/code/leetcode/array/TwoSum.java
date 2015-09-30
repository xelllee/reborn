package com.xelllee.code.leetcode.array;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p/>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum {


    public static void main(String[] args) {

        int[] arr = {3, 2, 4};


        System.out.println(twoSumHash(arr, 6));


    }


    public static String twoSumHash(int[] arr, int target) {

        long startTime = System.currentTimeMillis();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int num, diff;
        int[] res = new int[2];

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {

            num = arr[i];
            diff = target - num;

            if (map.containsKey(diff) && map.get(diff) != i) {

                return i + 1 + " - " + (map.get(diff) + 1);
            }

        }

        return "no way here";
    }

    private static String twoSum(int[] arr, int target) {

        int num, diff;

        //brute force
        for (int i = 0; i < arr.length; i++) {
            num = arr[i];
            if (i <= target) {

                diff = target - num;

                for (int j = i + 1; j < arr.length; j++) {

                    if (arr[j] == diff) {
                        return (i + 1) + " - " + (j + 1);
                    }
                }
            }
        }


        return "no way here";

    }


}
