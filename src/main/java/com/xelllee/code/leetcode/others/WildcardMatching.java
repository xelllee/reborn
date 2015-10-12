package com.xelllee.code.leetcode.others;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p/>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p/>
 * The matching should cover the entire input string (not partial).
 * <p/>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p/>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */



//TODO : save it later
public class WildcardMatching {


    public static void main(String[] args) {

        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aaa", "aa"));
        System.out.println(isMatch("aaa", "*"));
        System.out.println(isMatch("aaa", "a*"));
        System.out.println(isMatch("aaa", "?*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("", "*"));
        System.out.println(isMatch("b", "*?*?"));
        System.out.println(isMatch("abefcdgiescdfimde", "ab*cd?i*de"));

    }

    public static boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();
        if (m > n || (m == 0 && n > 0)) return false;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '?') {


            }


        }

        return false;
    }

}
