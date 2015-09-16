package com.xelllee.code.leetcode.string;

public class OneEditDistance {

//    Question:
//    Given two strings S and T, determine if they are both one edit distance apart.

    public static void main(String[] args) {


    }


    public static boolean makeItRight(String a, String b) {

        int m = a.length();
        int n = b.length();
        if (m > n) return makeItRight(b, a);
        int i = 0, d = 0, j = 0;

        if (n - m > 1) return false;

        else if (m == n) {
            while (i < m) {
                if (a.charAt(i) != b.charAt(i)) {
                    d++;
                    i++;
                }
            }
            return d == 1;
        } else {//(n - m == 1)
            while (i < m && j < n) {
                if (a.charAt(i) == a.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            return (j - i < 2);
        }

    }

}
