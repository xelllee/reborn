package com.xelllee.code.leetcode.others2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p/>
 * Return all possible palindrome partitioning of s.
 * <p/>
 * For example, given s = "aab",
 * Return
 * <p/>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {


    public static void main(String[] args) {

        System.out.println(partition("baabt"));
    }


    public static List<List<String>> partition(String str) {
        List<List<String>> lists = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        find(str, 0, list, lists);
        return lists;
    }


    public static void find(String str, int s, List<String> list, List<List<String>> lists) {


        if (s > (str.length() - 1)) {
            lists.add(list);
            return;
        }


        for (int i = s; i < str.length(); i++) {
            if (isPal(str, s, i)) {
                List<String> nlist = new ArrayList<String>(list);
                nlist.add(str.substring(s, i + 1));
                find(str, i + 1, nlist, lists);
            }
        }
    }


    public static boolean isPal(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }


}
