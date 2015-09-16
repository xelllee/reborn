package com.xelllee.code.leetcode.string;

import java.util.Arrays;

public class ReadNCharactersGivenRead4II {

    /*
    *
        Question:
        The API: int read4(char *buf) reads 4 characters at a time from a file.
        The return value is the actual number of characters read. For example, it returns 3 if there
        is only 3 characters left in the file.
        By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
        Note: The read function will only be called once for each test case.
*/
          //TODO:come back
    public static void main(String[] args) {


        int[] buffer = new int[10];
        Arrays.fill(buffer, 1);
        int[] buf = new int[10];


        System.out.println(Arrays.toString(buf));
        System.arraycopy(buffer /* src */, 0 /* srcPos */, buf /* dest */, 1 /* destPos */, 3 /* length */);

        System.out.println(Arrays.toString(buf));

    }


    public static int makeItRight(int[] nums) {

        return 0;

    }

}
