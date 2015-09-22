package com.xelllee.code.leetcode.misc;

import java.util.ArrayList;
import java.util.HashMap;

public class IntegerToRoman {


    /*
    *
    * I placed before V or X indicates one less, so four is IV (one less than five) and nine is IX (one less than ten)
X placed before L or C indicates ten less, so forty is XL (ten less than fifty) and ninety is XC (ten less than a hundred)
C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred) and nine hundred is CM

    * Question:
        Given an integer, convert it to a roman numeral.
        Input is guaranteed to be within the range from 1 to 3999.

        Symbol	Value
        I	1
        V	5
        X	10
        L	50
        C	100
        D	500
        M	1,000

        IV, IX, XL XC, CD,CM

    *
    *
    * */


    public static HashMap<String, Integer> map = new HashMap<String, Integer>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

    }


    public static void main(String[] args) {


        System.out.println(romanToInt("XIII"));
    }


    public static int romanToInt(String s) {

        char[] arr = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            if (i <= (arr.length - 2) && map.get(arr[i] + "") < map.get(arr[i + 1] + "")) {
                sum += map.get(String.valueOf(arr[i]) + String.valueOf(arr[i + 1]));
                i++;
            } else {
                sum += map.get(arr[i] + "");
            }
        }
        return sum;
    }


}
