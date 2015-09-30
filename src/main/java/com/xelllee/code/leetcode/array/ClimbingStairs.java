package com.xelllee.code.leetcode.array;

import java.util.HashMap;

public class ClimbingStairs {

//
//    You are climbing a stair case. It takes n steps to reach to the top.
//
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


    //

    public static void main(String[] args) {

        //111,12,21

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


        long start = System.currentTimeMillis();

        System.out.println(makeItRight(160, map));

        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(makeItRight3(160));
        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(makeItRight2(45));
    }


    //BEST !!
    public static int makeItRight3(int n) {
        if (n <= 2) return n;
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];

    }

    public static int makeItRight(int n, HashMap<Integer, Integer> map) {

        if (n < 0) return 0;

        else if (n == 1) return 1;

        else if (n == 2) return 2;

        else {

            int n1, n2;

            if (map.containsKey(n - 1)) {
                n1 = map.get(n - 1);
            } else {
                n1 = makeItRight(n - 1, map);
                map.put(n - 1, n1);
            }
            if (map.containsKey(n - 2)) {
                n2 = map.get(n - 2);
            } else {
                n2 = makeItRight(n - 2, map);
                map.put(n - 2, n2);
            }

            return n1 + n2;
        }

    }


    public static int makeItRight2(int n) {

        if (n < 0) return 0;

        else if (n == 1) return 1;

        else if (n == 2) return 2;

        else {


            return makeItRight2(n - 1) + makeItRight2(n - 2);
        }
    }

}
