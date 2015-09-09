package com.xelllee.code.leetcode.string;

public class StringToInteger {


    /*
    * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases.
If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 You are responsible to gather all the input requirements up front.



Implement atoi to convert a string to an integer.
The atoi function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number,
 or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.
If the correct value is out of the range of representable values, the maximum integer value (2147483647) or the minimum integer value (–2147483648) is returned.
 */
    public static void main(String[] args) {


//        System.out.println(atoi("23a"));
//        System.out.println(makeItRight("23a"));
        System.out.println(makeItRight("-2147483647"));


    }


    public static int makeItRight(String str) {


        if (str.isEmpty()) return 0;

        int i = 0;

        while (str.charAt(i) == ' ') i++;
        int sign = -1;
        int num = 0;

        char f = str.charAt(i);

        if (f == '-') {
            sign = -1;
            i++;
        } else if (f == '+') {
            sign = 1;
            i++;
        } else if (Character.isDigit(f)) {
            num = Character.getNumericValue(f);
            sign = 1;
            i++;
        }


        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && Character.getNumericValue(str.charAt(i)) >= 8) {
                return (sign < 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + Character.getNumericValue(str.charAt(i));
            i++;
        }


        return sign * num;

    }

    private static final int maxDiv10 = Integer.MAX_VALUE / 10;

    public static int atoi(String str) {
        int i = 0, n = str.length();
        while (i < n && Character.isWhitespace(str.charAt(i))) i++;
        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }

}
