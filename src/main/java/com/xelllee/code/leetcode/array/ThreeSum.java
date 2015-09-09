package com.xelllee.code.leetcode.array;

import java.util.*;

public class ThreeSum {

//    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//
//            Note:
//    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//    The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},
//
//    A solution set is:
//            (-1, 0, 1)
//            (-1, -1, 2)
//


    public static void main(String[] args) {

//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0};
//        int[] nums = {13, 11, -3, -1, 6, -11, -11, -12, 1, -11, -10, 12, 3, -11, 0, 9, 3, -13, -10, -2, 6, 14, 9, -4, -9, -3, -9, -15, -10, 4, -7, 10, 1, -3, -5, 14, 1, -9, -13, -12, -4, -8, 7, 6, -4, -8, 0, 6, -14, -3, -11, 0, -4, 13, 3, 2, -13, 9, 2, 14, -1, 10, 10, 7, 14, 12, 6, 0, -12, 0, -5, -9, 7, -13, 12, 10, -13, -3, 1, 10, 9, 5, -5, 12, -5, 13, -1, -11, 0, -14, -11, 6, 3, 14, -2, 2, 11, 11, 10, 6, -4, 12, 13, 10, 7, 10, 5, 1};

        System.out.println(makeItRight(nums));
        System.out.println(makeItRight2(nums));

    }


    //
    public static List<List<Integer>> makeItRight(int[] nums) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return list;


        ArrayList<Integer> sub;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }


            int p = i + 1, q = nums.length - 1;

            while (p < q) {

                int sum = nums[i] + nums[p] + nums[q];

                if (sum == 0) {

                    sub = new ArrayList<Integer>();

                    int qv = nums[q];
                    int pv = nums[p];

                    sub.add(nums[i]);
                    sub.add(pv);
                    sub.add(qv);
                    list.add(sub);

                    p++;
                    q--;

                    while (q > 0 && qv == nums[q]) {
                        q--;
                    }

                    while (p < nums.length && pv == nums[p]) {
                        p++;
                    }


                } else if (sum < 0) {
                    p++;
                } else {
                    //sum > 0
                    q--;
                }

            }

        }

        return list;
    }


    //brute
    public static List<List<Integer>> makeItRight2(int[] nums) {

        if (nums == null || nums.length < 3) return null;

        HashSet<List<Integer>> list = new HashSet<List<Integer>>();

        HashMap<Integer, List<HashSet<Integer>>> map = new HashMap<Integer, List<HashSet<Integer>>>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                HashSet<Integer> set = new HashSet<Integer>(2);

                int twosum = nums[i] + nums[j];
                set.add(i);
                set.add(j);

                if (map.containsKey(twosum)) {
                    map.get(twosum).add(set);
                } else {
                    ArrayList<HashSet<Integer>> setlist = new ArrayList<HashSet<Integer>>();
                    setlist.add(set);
                    map.put(twosum, setlist);
                }


            }
        }


        for (int i = 0; i < nums.length; i++) {

            int diff = (0 - nums[i]);

            if (map.containsKey(diff)) {
                List<HashSet<Integer>> setlist = map.get(diff);


                for (HashSet<Integer> set : setlist) {

                    if (!set.contains(i)) {
                        Integer[] tmp = new Integer[3];
                        tmp[0] = nums[i];
                        int counter = 1;

                        for (int num : set) {
                            tmp[counter] = nums[num];
                            counter++;
                        }
                        Arrays.sort(tmp);
                        list.add(Arrays.asList(tmp));
                    }

                }


            }
        }


        return new ArrayList<List<Integer>>(list);
    }


}
