package com.xelllee.code.leetcode.others;



/*
*
Given a string S, find the longest palindromic substring in S.
 You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic
* */


import java.util.Arrays;

public class LongestPalindromicSubstring {


    public static void main(String[] args) {


//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s = "aaabbaaaa";


//        long start = System.currentTimeMillis();
//        System.out.println(longestPalindrome1(s));
//        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
        System.out.println(longestPalindromeDp(s));
//        System.out.println(System.currentTimeMillis() - start);

    }


    private static int max = 0;
    private static int maxi, maxj;


    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
// get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
// get longest palindrome with center of i, i+1 tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }

    public static String helper(String s, int begin, int end) {

        while ((begin >= 0 && end <= s.length() - 1) && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);

    }

    public static String longestPalindrome1(String s) {

        char[] arr = s.toCharArray();
        int n = arr.length;
        //pal[i][j] denotes from s[i] to s[j] is palindrom (2: false, 1: true, 0: unknown);
        int[][] pal = new int[n][n];

        findPal(arr, 0, n - 1, pal);
        return s.substring(maxi, (maxj + 1));

    }

    public static int findPal(char[] arr, int s, int e, int[][] pal) {

        if (pal[s][e] == 0) {
            if (arr[s] == arr[e]) {
                if ((s == e || e - s == 1)) {
                    pal[s][e] = 1;
                } else {
                    pal[s][e] = findPal(arr, s + 1, e - 1, pal);
                }
            } else {
                pal[s][e] = 2;
            }
            if (pal[s][e] == 2) {
                pal[s + 1][e] = findPal(arr, s + 1, e, pal);
                if (pal[s + 1][e] == 2) {
                    pal[s][e - 1] = findPal(arr, s, e - 1, pal);
                }
            }
        }

        if (pal[s][e] == 1 && (e - s >= max)) {
            max = e - s;
            maxi = s;
            maxj = e;
        }

        return pal[s][e];
    }

    public static String longestPalindromeDp(String s) {


        if (s == null) return null;
        if (s.length() < 2) return s;

        int length = s.length();
        boolean[][] table = new boolean[length][length];
        int maxs = 0, maxe = 0, maxlen = 1;

        for (int i = 0; i < length; i++) {
            table[i][i] = true;
        }

        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                maxlen = 2;
            }
        }

        //length = 3, 1, (3-2+1) = 2

        for (int len = 3; len < length; len++) {
            for (int i = 0; i < (length - len + 1); i++) {
                int e = i + len - 1;
                if (s.charAt(i) == s.charAt(e) && table[i + 1][e - 1]) {
                    table[i][e] = true;
                    if (len >= maxlen) {
                        maxe = e;
                        maxs = i;
                        maxlen = len;
                    }
                }
            }
        }


        return s.substring(maxs, maxe + 1);
    }

    public static String longestPalindrome2(String s) {

        if (s == null || s.length() < 2) return s;
        String longest = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {

            String p1 = expand(s, i, i);
            if (p1.length() > longest.length()) longest = p1;
            String p2 = expand(s, i, i + 1);
            if (p2.length() > longest.length()) longest = p2;

        }
        return longest;
    }

    public static String expand(String str, int s, int e) {

        int l = s, r = e;
        while (str.charAt(s) == str.charAt(e) && (s >= 0 && e <= str.length() - 1)) {
            l--;
            r++;
        }
        return str.substring(l + 1, r - 1);

    }

}
