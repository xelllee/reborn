package com.xelllee.code.leetcode.math;

public class PalindromeNumber {


    public static void main(String[] args) {


        System.out.println(makeItRight(2147447412));

    }


    public static boolean makeItRight(int x) {


        if (x < 0) return false;
        int y = 0, t = x;

        //chopping head and tail to avoid overflow.


        while (t != 0) {
            y = y * 10 + (t % 10);
            t /= 10;
        }

        return y == x;

    }

}
