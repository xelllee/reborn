package com.xelllee.code.leetcode.string;

import java.util.Arrays;

public class LongestSubstringwithAtMostTwoDistinctCharacters {


    /*
    Given a string S, find the length of the longest substring T that contains at most two distinct characters.
    For example,
    Given S = “eceba”,
    T is "ece" which its length is 3.
*/

    public static void main(String[] args) {


//        System.out.println(makeItRight("aaaaaafeeeeeeeerffdfjfdkjjfdddddddddddoooooofgdgdg"));
        System.out.println(makeItRight2("a"));

    }


//    public static int makeItRight(String s) {
//
//        int max = 0, q = 0, p = 0, i;
//        char a = '\000', b = '\000';
//
//        while (q < s.length()) {
//
//            if (s.charAt(q) != a && s.charAt(q) != b) {
//
//
//            }
//
//        }
//
//        return max;
//
//    }

    public static int makeItRight2(String s) {
        int i = 0, j = -1, maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                maxLen = Math.max(k - i, maxLen);
                i = j + 1;
            }
            j = k - 1;
        }
        return Math.max(s.length() - i, maxLen);
    }

}
