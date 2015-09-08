package com.xelllee.code.leetcode;

public class TrappingRainWater {

    /*
    *
    * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

    For example,
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     http://www.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png

    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
    In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
    * */


    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(makeItRight(nums));
    }


    //n2
    public static int makeItRight(int[] height) {


        if (height == null || height.length < 3) return 0;

        int sum = 0;
        int sv = 0;
        int tmp = 0;
        int nep = 0;
        boolean started = false;

        for (int i = 0; i < height.length; i++) {

            if (started) {
                if (i == nep) {
                    sum += tmp;
                    started = false;
                } else {
                    tmp += sv - height[i];
                }
            }

            if (!started && height[i] > 0) {
                tmp = 0;
                sv = height[i];
                started = true;
                nep = findMaxEnd(height, i, sv);
                sv = Math.min(sv, height[nep]);
                if (nep == 0) return sum;
            }
        }

        return sum;

    }

    private static int findMaxEnd(int[] arr, int s, int sv) {

        int maxev = 0;
        int maxep = 0;
        for (int i = s + 1; i < arr.length; i++) {

            if (arr[i] >= sv) {
                return i;
            } else if (arr[i] >= maxev) {
                maxep = i;
                maxev = arr[i];
            }

        }
        return maxep;
    }

}
