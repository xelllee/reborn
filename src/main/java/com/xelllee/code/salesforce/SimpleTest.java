package com.xelllee.code.salesforce;

/**
 * Given a array of integer and group size, reverse array by group size, example as follows:
 * [1, 2, 3, 4, 5, 6], 1 -> [1, 2, 3, 4, 5, 6]
 * [1, 2, 3, 4, 5, 6], 2 -> [2, 1, 4, 3, 6, 5]
 * [1, 2, 3, 4, 5, 6], 3 -> [3, 2, 1, 6, 5, 4]
 * [1, 2, 3, 4, 5, 6, 7, 8], 3 -> [3, 2, 1, 6, 5, 4, 8, 7]
 * Design test cases for you API
 */
public class SimpleTest {


    public static void main(String[] args){


        int[] arr = {10 ,11 ,2 ,3 ,4 ,5 ,6 ,7, 8 ,9} ;


        System.out.println(find(arr,0,arr.length-1,3));
    }




    public static boolean find(int[] arr, int s, int e, int x){
        if(e < s) return false;

        int mid = (s + e)/2;

        if(arr[mid] == x ) return true;

        if( (x >= arr[s] && x <= arr[mid]) || (x <= arr[s] && x <= arr[mid])){
            return find(arr,s,mid,x);
        }   else {
            return find(arr,mid+1,e,x);
        }

    }

}
