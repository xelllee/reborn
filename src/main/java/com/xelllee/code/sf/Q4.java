package com.xelllee.code.sf;


/**
 * 1> write program to calculate power(x,n) in log(n) time
 */
public class Q4 {

    public static void main(String[] args) {

        System.out.println(pow(2,3));


    }


    public static long pow(int x, int n) {

        if (n == 0) return 1;
        if (n == 1) return x;

        long pwd = (long) Math.pow(x, n / 2);

        return (n % 2 == 0) ? pwd * pwd : pwd * pwd * x;
    }


}
