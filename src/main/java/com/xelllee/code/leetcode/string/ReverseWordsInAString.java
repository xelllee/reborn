package com.xelllee.code.leetcode.string;

import java.util.ArrayList;

public class ReverseWordsInAString {


    /*
    Question:
    Given an input string s, reverse the string word by word.

       reverse the string word by word.

       .word by word string the reverse

    For example, given s = "the sky is blue", return "blue is sky the".
    Example Questions Candidate Might Ask:
    Q: What constitutes a word?
    A: A sequence of non-space characters constitutes a word.
            Q: Does tab or newline character count as space characters?
    A: Assume the input does not contain any tabs or newline characters.
            Q: Could the input string contain leading or trailing spaces?
    A: Yes. However, your reversed string should not contain leading or trailing spaces.
    Q: How about multiple spaces between two words?
    A: Reduce them to a single space in the reversed string.



    */
    public static void main(String[] args) {


        String s = "reverse the string word by word.";
//        String s = "1 ";
//        String s = "a";

//        System.out.println(s.charAt(1));

        System.out.println(makeItRight(s));


    }


    public static String makeItRight(String s) {

        StringBuilder sb = new StringBuilder();
        int start = -1;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (start > 0) {
                if (s.charAt(i) == ' ') {
                    for (int n = i + 1; n <= start; n++) {
                        sb.append(s.charAt(n));
                    }
                    sb.append(' ');
                    start = -1;
                }
            } else {
                if (s.charAt(i) != ' ') {
                    start = i;
                }
            }
        }

        if (start >= 0) {
            for (int n = 0; n <= start; n++) {
                if (s.charAt(n) != ' ')
                    sb.append(s.charAt(n));
            }
        } else if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }

}
