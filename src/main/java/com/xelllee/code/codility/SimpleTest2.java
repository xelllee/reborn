package com.xelllee.code.codility;

public class SimpleTest2 {


    public static void main(String[] args) {

//        int[] A = {1, 2, 5, 4, 3};
        int[] A = {1, 3, 2,3, 4, 6};
//        int[] A = {1, 5, 3, 3, 7};
//        int[] A = {1, 2, 3, 3, 7};
//        int[] A = {1};


        System.out.println(solution(A));

    }

    public static boolean solution(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if ((i == 0 && arr[i + 1] < arr[i]) ||
                    ((i > 0) && (arr[i - 1] > arr[i] || arr[i] > arr[i + 1]))) {
                for (int j = arr.length - 1; j > i; j--) {
                    if (arr[j] < arr[i]) {
                        int tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;
                        break;
                    }
                }
                break;
            }
        }

        return isNonDesc(arr);
    }

    public static boolean isNonDesc(int[] A) {

        if (A.length < 2) return true;
        int last = A[0];
        for (int a : A) {
            if (a >= last) {
                last = a;
            } else {
                return false;
            }
        }
        return true;
    }

}
