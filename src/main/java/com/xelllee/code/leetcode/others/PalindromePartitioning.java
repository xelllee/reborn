package com.xelllee.code.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {


    public static void main(String[] args) {
        String s = "aab";
        partition(s);
    }

    public static List<List<String>> partition(String s) {

        List<List<String>> lists = new ArrayList<List<String>>();
        find(s, 0, new ArrayList<String>(), lists);
        return lists;
    }


    public static void find(String s, int p, List<String> list, List<List<String>> lists) {

        //end
        int n = s.length();
        if (p == n - 1) {
            lists.add(list);
            System.out.println(list);
            return;
        }
        int rest = n - p;
        for (int len = 1; len < rest; len++) {
            if (isPal(s, p, len)) {
                List<String> list2 = new ArrayList<String>();
                list2.addAll(list);
                list2.add(s.substring(p, p + len));
                find(s, p + len, list2, lists);
            }
        }
    }


    public static boolean isPal(String s, int p, int len) {

        if(len == 1) return true;

        int l = p;
        int r = p + len;
        while (r > l) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
