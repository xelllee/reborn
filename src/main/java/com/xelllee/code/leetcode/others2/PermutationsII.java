package com.xelllee.code.leetcode.others2;

import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p/>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2,1};

        System.out.println(permuteUnique(nums));

    }


    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();

        if (num == null || num.length == 0)
            return res;
        boolean[] visited = new boolean[num.length];
        Arrays.sort(num);
        permutationhelper(res, num, item, visited, 0);
        return res;
    }

    public static void permutationhelper(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> item, boolean[] visited, int start) {
        if (item.size() == num.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = start; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1] && !visited[i - 1])
                continue;
            if (!visited[i]) {
                item.add(num[i]);
                visited[i] = true;
                permutationhelper(res, num, item, visited, start);
                visited[i] = false;
                item.remove(item.size() - 1);
            }
        }
    }


}
