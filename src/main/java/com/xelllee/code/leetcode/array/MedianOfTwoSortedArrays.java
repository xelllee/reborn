package com.xelllee.code.leetcode.array;


public class MedianOfTwoSortedArrays {

//    There are two sorted arrays nums1 and nums2 of size m and n respectively.
//    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).


    //TODO: come back later.

    public static void main(String[] args) {

        //  6,    8
        int[] nums1 = {1, 2, 5, 7, 9, 10}, nums2 = {5, 6, 8, 11, 18};

        //     {1,2,5,5,6, 7 ,8,9,10,11,18}

//        System.out.println(Math.round(2.5));

//        int[] nums = {1, 2, 5, 5, 6, 7, 8, 9, 10, 11, 18};
        int[] nums = {1, 2, 5, 5, 6, 9, 10};

//        System.out.println(median(nums, 3, 6));
        System.out.println((int) Math.floor((6 / 2)));
    }


    public static double makeItRight(int[] nums1, int[] nums2) {


        //null cases
        if (nums1 == null || nums2 == null) {
            if (nums1 == null && nums2 == null) {
                return 0;
            } else if (nums1 == null) {
                return median(nums2, 0, nums2.length);
            } else {
                return median(nums1, 0, nums1.length);
            }
        }

        // even : leave 2 elemetns, odd : leave 1 element
        int balance = (int) Math.floor(((nums1.length + nums2.length) - 1) / 2);


        int right = 0, left = 0;
        int s1 = 0, s2 = 0, e1 = nums1.length, e2 = nums2.length, l1, l2, r1, r2;
        double m1, m2;


        while (right != left || right != balance) {

            m1 = median(nums1, s1, e1);
            m2 = median(nums2, s2, e2);

            if (m1 < m2) {

                l1 = (int) Math.floor(((e1 - s1 + 1) - 1) / 2);
                r2 = (int) Math.floor(((e2 - s2 + 1) - 1) / 2);

                left += l1;
                right += r2;

                s1 += l1;
                e2 -= r2;

            } else if (m1 > m2) {

                l2 = (int) Math.floor(((e2 - s2 + 1) - 1) / 2);
                r1 = (int) Math.floor(((e1 - s1 + 1) - 1) / 2);

                left += l2;
                right += r1;

                s2 += l2;
                e1 -= r1;

            } else {
                //m1 == m2
                return m1;
            }
        }
        return 0;

    }


    private static double median(int[] nums, int start, int end) {
        //[], 0,5
        boolean even = ((end - start + 1) & 1) == 0;
        int mid = (int) Math.floor((end - start) / 2) + start;
        return even ? ((double) (nums[mid] + nums[mid + 1]) / 2) : nums[mid];
    }


}
