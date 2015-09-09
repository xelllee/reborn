package com.xelllee.code.leetcode.string;

public class ValidNumber {

    /*
    * Validate if a given string is numeric.

Some examples:
"0" => true
"0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
    * */

    public static void main(String[] args) {


    }


    public static boolean makeItRight(String s) {

        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isNumeric = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        if (isNumeric && i < n && s.charAt(i) == 'e') {
            i++;
            isNumeric = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isNumeric && i == n;

    }

}
