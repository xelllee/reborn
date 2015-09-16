package com.xelllee.code.leetcode.string;

public class LongestPalindromicSubstring {

//    Given a string S, find the longest palindromic substring in S.
// You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


    //   abcde cghih        10/2

    //TODO: come back

    public static void main(String[] args) {

        System.out.println(Math.floor((double) 11 / 2));
        System.out.println(Math.ceil((double) 11 / 2));
        System.out.println(11 / 2);

    }


    public static String makeItRight(String s) {


        char[] arr = s.toCharArray();
        double len = (double) arr.length;
        int l = (int) Math.floor(len / 2);
        int r = (int) Math.ceil(len / 2);

        int max = findMax(l, r, arr);
        int left = l;
        int right = r;


        while (l > 0 && r < arr.length) {

//            max = Math.max(max, findMax(l))


        }

        return "";

    }

    public static int findMax(int l, int r, char[] arr) {

        int max = 0;
        while (l > 0 && r < arr.length) {
            if (arr[l] == arr[r]) {
                max++;
            } else {
                return max;
            }
            l--;
            r++;
        }
        return max;
    }


}
