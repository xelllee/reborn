package com.xelllee.code.leetcode.string;

public class ValidPalindrome {


    /*
    *
    *Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

    public static void main(String[] args) {

        System.out.println(makeItRight("A man, a plan, a canal: Panama"));
        System.out.println(makeItRight("a."));


    }

    public static boolean makeItRight(String s) {

        if (s.isEmpty()) return true;

        int q = 0, p = s.length() - 1;

        s = s.toLowerCase();

        while (q <= p) {
            char l = '\0', r = '\0';

            while (q <= p) {
                if (Character.isLetterOrDigit(s.charAt(q))) {
                    l = s.charAt(q);
                    break;
                } else {
                    q++;
                }

            }

            while (q <= p) {
                if (Character.isLetterOrDigit(s.charAt(p))) {
                    r = s.charAt(p);
                    break;
                } else {
                    p--;
                }
            }

            if (l != r) return false;

            p--;
            q++;

        }

        return true;

    }

}
