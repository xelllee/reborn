package com.xelllee.code.leetcode.bit;

import java.util.Arrays;

public class SimpleTest {


    /*
    * Given an array of integers, every element appears twice except for one. Find that single one.
    * Given an array of integers, every element appears three times except for one. Find that single one(appear once).

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    01,  ~
    10,
    11

    * */

    public static void main(String[] args) {
        int a = 60;	/* 60 = 0011 1100 */
        int b = 13;	/* 13 = 0000 1101 */
        int c = 0;

        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c);

        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c);

        c = a ^ b;       /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c);

        c = ~a;          /*-61 = 1100 0011 */
        System.out.println("~a = " + c);

        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c);

        c = a >> 2;     /* 215 = 1111 */
        System.out.println("a >> 2  = " + c);

        c = a >>> 2;     /* 215 = 0000 1111 */
        System.out.println("a >>> 2 = " + c);

    }

    int singleNumber(int A[], int n) {

        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < n; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }


    public static int makeItRight(int[] nums) {

        int[] arr = new int[32];
        int[] narr = new int[32];
        int c = 1000000;

        for (int num : nums) {
            char[] bin = Integer.toBinaryString(Math.abs(num) - c).toCharArray();

            for (int j = 0; j < bin.length; j++) {
                if (num >= 0)
                    arr[bin.length - j - 1] += bin[j] == '0' ? 0 : 1;
                else
                    narr[bin.length - j - 1] += bin[j] == '0' ? 0 : 1;
            }
        }

        String tmp = "";
        for (int t = arr.length - 1; t >= 0; t--) {
            if (arr[t] % 3 != 0 || !tmp.isEmpty()) {
                tmp += "1";
            }
        }

        if (!tmp.isEmpty() && Integer.parseInt(tmp, 2) != 0) return Integer.parseInt(tmp, 2);

        else {
            tmp = "";
            for (int t = narr.length - 1; t >= 0; t--) {
                if (narr[t] % 3 != 0 || !tmp.isEmpty()) {
                    tmp += (narr[t] % 3 + "");
                }
            }
            return -1 * (Integer.parseInt(tmp, 2) + c);
        }
    }

}
