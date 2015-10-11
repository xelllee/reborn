package com.xelllee.code.leetcode.others;



/*
*
Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
* */


public class MedianofTwoSortedArrays {

    public static void main(String[] args) {

        int[] arr1 = {};
        int[] arr2 = {1};

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }


    // 1: [1], [1, 2];

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n + 1) / 2;
        // 1: mid = 2;

        int counter = 0, q = 0, p = 0;
        double median;

        while (true) {

            if (q < m && p < n) {
                if (nums1[q] <= nums2[p]) {
                    median = nums1[q];
                    q++;
                } else {
                    median = nums2[p];
                    p++;
                }
            } else if (q < m) {
                median = nums1[q];
                q++;
            } else {
                median = nums2[p];
                p++;
            }

            counter++;
            if (counter == mid) {
                break;
            }
        }
        if ((m + n) % 2 == 0) {

            return (((q < m && p < n) ? ((nums1[q] <= nums2[p]) ? nums1[q] : nums2[p]) : ((q < m) ? nums1[q] : nums2[p])) + median) / 2;

        } else {

            return median;
        }
    }

}


//n , n -2 , n-2 , n-2 ,