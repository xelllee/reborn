package com.xelllee.code.leetcode;

import java.util.Arrays;

public class PlusOne {
//
//    Given a non-negative number represented as an array of digits, plus one to the number.
//
//    The digits are stored such that the most significant digit is at the head of the list.

    public static void main(String[] args) {


//        int[] digits = {3, 2, 9}; // {3,3,0}
        int[] digits = {9, 9}; // {3,3,0}

        System.out.println(Arrays.toString(makeItRight(digits)));

    }


    public static int[] makeItRight(int[] digits) {


        int[] dig = {1};

        if (digits == null || digits.length == 0) return dig;

        for (int i = digits.length - 1; i >= 0; i--) {

            int d = digits[i] + 1;

            if (d > 9) {
                digits[i] = 0;
                if (i == 0) {
                    int[] newdigits = new int[digits.length + 1];
                    newdigits[0] = 1;
                    return newdigits;
                }
            } else {
                digits[i] = d;
                break;
            }
        }
        return digits;
    }

}
