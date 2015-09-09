package com.xelllee.code.leetcode.string;

public class ReverseWordsInAStringII {


    /*

Similar to Question [6. Reverse Words in a String], but with the following constraints:
“The input string does not contain leading or trailing spaces and the words are always separated by a single space.”
Could you do it in-place without allocating extra space?


    */
    public static void main(String[] args) {


//        char[] s = "reverse the string word by word".toCharArray();
        char[] s = "a".toCharArray();

//        System.out.println(s);
        makeItRight(s);
//

    }


    public static void makeItRight(char[] s) {

        if (s == null) return;

        int q = 0, p = s.length - 1;
        char tmp;

        while (q < p) {
            tmp = s[q];
            s[q] = s[p];
            s[p] = tmp;
            p--;
            q++;
        }
        q = 0;
        p = 0;
        int stop;

        while (p < s.length) {

            while (s[p] != ' ') {
                if (p == s.length - 1) break;
                p++;
            }

            stop = (s[p] == ' ') ? p - 1 : p;

            while (q < stop) {
                tmp = s[q];
                s[q] = s[stop];
                s[stop] = tmp;
                stop--;
                q++;
            }
            p++;
            q = p;
        }

        System.out.println(s);

    }

}
