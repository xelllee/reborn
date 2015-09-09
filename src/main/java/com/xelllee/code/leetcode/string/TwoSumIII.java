package com.xelllee.code.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {


    /*
    *
     Design and implement a TwoSum class. It should support the following operations: add and find.
add(input) – Add the number input to an internal data structure.
find(value) – Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5); find(4)true; find(7)false
    * */


    //hashmap

    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int num) {
        if (map.containsKey(num)) {
            map.put(num, 2);
        } else {
            map.put(num, 1);
        }
    }

    public boolean find(int target) {

        if (map.size() < 2) return false;

        if ((target & 1) == 1) {
            if (map.containsKey(target / 2) && map.get(target / 2) == 2) return true;
        }


        for (int key : map.keySet()) {

            if (map.containsKey(target - key) && (target - key != key)) return true;
        }
        return false;
    }


    public static void main(String[] args) {


    }


    public static int makeItRight(int[] nums) {


        return 0;

    }

}
