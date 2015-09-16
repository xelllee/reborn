package com.xelllee.code.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingRanges {

    /*
    *
    Question:
    Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
    For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]


*/


    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 6, 7, 8, 50, 75};
        int[] arr = {};
        System.out.println(makeItRight(arr));

    }


    public static ArrayList<String> makeItRight(int[] nums) {

        ArrayList<String> list = new ArrayList<String>();
        int s = -1, e;
        for (int i = 0; i <= nums.length; i++) {
            e = (i != nums.length) ? nums[i] : 100;
            if (e - s > 1) {
                if (e - s == 2) {
                    list.add((s + 1) + "");
                } else {
                    list.add((s + 1) + "->" + (e - 1));
                }
            }
            s = e;
        }
        return list;
    }

}
