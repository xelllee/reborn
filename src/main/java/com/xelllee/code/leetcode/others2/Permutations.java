package com.xelllee.code.leetcode.others2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {

    public static void main(String[] args) {

        int[] nums = {1};

       System.out.println(permute(nums));

    }

    public static List<List<Integer>> permute(int[] nums) {


        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> item = new ArrayList<Integer>();

        find(item, visited, nums, lists);


        return lists;
    }


    public static void find(List<Integer> item, boolean[] visited, int[] nums, List<List<Integer>> lists) {


        if (item.size() == nums.length) {
            lists.add(new ArrayList<Integer>(item));
//            System.out.println(item);
        } else {

            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    item.add(nums[i]);
                    find(item, visited, nums, lists);
                    item.remove(item.size() - 1);
                    visited[i] = false;

                }
            }

        }


    }


}
