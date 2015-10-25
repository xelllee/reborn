package com.xelllee.code.leetcode.others2;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p/>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p/>
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {

    public static void main(String[] args) {

        int[] arr = new int[4];
//        System.out.println(Arrays.toString(arr));

        System.out.println(minCut1("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
//        System.out.println(minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
    }

    public static int minCut1(String s) {
        int min = 0;
        int len = s.length();
        boolean[][] matrix = new boolean[len][len];
        int cuts[] = new int[len + 1];

        if (s == null || s.length() == 0)
            return min;
        //初始化cuts里面的值为最坏情况的值
        for (int i = 0; i < len; ++i) {
            cuts[i] = len - i;
        }
        //dp过程
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i; j < len; ++j) {
                if ((s.charAt(i) == s.charAt(j) && (j - i < 2))
                        || (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1])) {
                    matrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        min = cuts[0];
        return min - 1;
    }

    public static int minCut(String s) {

        int n = s.length();
        int[][] t = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (isNumPal(s, 0, i, t)) return i;
        }

        return 0;
    }

    public static boolean isNumPal(String str, int s, int cut, int t[][]) {

        if (cut == 0) {
            return isPal(str, s, str.length() - 1, t);
        } else {
            for (int i = s; i < str.length(); i++) {
                if (isPal(str, s, i, t)) {
                    if (isNumPal(str, i + 1, (cut - 1), t)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isPal(String str, int s, int e, int t[][]) {

        if (t[s][e] != 0) return (t[s][e] > 0);
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                t[s][e] = -1;
                return false;
            }
            s++;
            e--;
        }
        t[s][e] = 1;
        return true;
    }


}
