package com.xelllee.code.leetcode.others;

/**
 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?


 solution:

    0, assume the two number is a, b
    1, xor number one by one.  a^b = xor;
    2, find all 1 in xor, (e.g = 3 (11)) meaning, a, b have to be different at those two digits
    3, divide the nums into two group by xor last 1 didgits, and xor each other then you will have a,b

 */
public class SingleNumberIII {

    public static void main(String[] args){




        System.out.println(3^5^3^2^1^5);
        System.out.println((~3)^2);
        System.out.println(~3^1);
        System.out.println(~3^5);
    }



    public int[] singleNumber(int[] nums) {
        int[] value = new int[2];
        if (nums.length <= 2) {
            return nums;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        String hex = Long.toBinaryString(result);
        int x = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            if (hex.charAt(i) == '1') {
                x = (int)Math.pow(2, hex.length() - 1 - i);
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & x) == x) {
                value[0] ^= nums[i];
            }else{
                value[1] ^= nums[i];
            }
        }
        return value;
    }


}
