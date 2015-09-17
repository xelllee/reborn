package com.xelllee.code.leetcode.math;

public class ReverseInteger {

//    Question:
//    Reverse digits of an integer. For example: x = 123, return 321.


    public static void main(String[] args) {


        System.out.println(makeItRight(0));

    }


    public static int makeItRight(int x) {

        int sign = (x < 0) ? -1 : 1;
        long r = 0;
        int t = Math.abs(x);
        int d;
        while (t > 0) {
            d = t - (t / 10 * 10);
            if (r > (Integer.MAX_VALUE / 10)) return 0;
            r = r * 10 + d;
            t = t / 10;
        }


        return (r * sign < Integer.MIN_VALUE || r * sign > Integer.MAX_VALUE) ? 0 : (int)(r * sign);

    }

}
