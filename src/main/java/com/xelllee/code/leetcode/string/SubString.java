package com.xelllee.code.leetcode.string;

public class SubString {


    /*
    *
    * Implement strStr().

      Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    */

    public static void main(String[] args) {

        System.out.print(makeItRight("mississippi", "a"));


    }


    public static int makeItRight(String haystack, String needle) {

        if (needle.isEmpty()) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) return -1;
            for (int j = 0; j < needle.length(); j++) {
                if (!(needle.charAt(j) == haystack.charAt(i + j))) break;
                else if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }

}
