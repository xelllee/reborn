package com.xelllee.code.leetcode;

import java.util.Arrays;

public class SimpleTest {


    public static void main(String[] args) {


        System.out.println(Math.round(2.5));

    }


    public static int makeItRight(int[] nums) {

        long startTime = System.currentTimeMillis();

        System.out.println(Arrays.toString(nums));


        System.out.println("Took :" + (System.currentTimeMillis() - startTime) + " ms");
        return 0;

    }

}
