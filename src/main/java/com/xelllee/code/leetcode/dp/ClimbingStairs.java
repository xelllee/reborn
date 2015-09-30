package com.xelllee.code.leetcode.dp;


import java.util.HashMap;

public class ClimbingStairs {

/*

    Question:
    You are climbing a staircase. It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to
    the top?

* */

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }


    public static int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return count(n, map);
    }

    public static int count(int n, HashMap<Integer, Integer> map) {


        if (n <= 0) return 0;

        int count;
        if (map.containsKey(n))
            count = map.get(n);
        else if (n == 1) {
            count = 1;
        } else if (n == 2) {
            count = 2;
        } else {
            count = count(n - 1, map) + count(n - 2, map);
        }
        map.put(n, count);

        return count;
    }

}
