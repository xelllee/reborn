package com.xelllee.code.leetcode.misc;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class RomanToInteger {


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


    public static TreeMap<Integer, String> map = new TreeMap<Integer, String>(Collections.reverseOrder());

    static {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }


    public static void main(String[] args) {


        System.out.println(intToRoman(998));
        //CMXCIX  //CMXCVIII
    }

    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        int r = num, n;

        for (int i : map.keySet()) {
            n = (r / i);
            while (n != 0) {
                sb.append(map.get(i));
                n--;
            }
            r %= i;
        }

        return sb.toString();
    }



}
