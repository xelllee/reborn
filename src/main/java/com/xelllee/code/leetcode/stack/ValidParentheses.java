package com.xelllee.code.leetcode.stack;


import java.util.Stack;

public class ValidParentheses {

/*


Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
* */

    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(') {
                stack.push(')');
            } else if (arr[i] == '{') {
                stack.push('}');
            } else if (arr[i] == '[') {
                stack.push(']');
            } else if (arr[i] == ']') {
                if (stack.empty() || stack.pop() != arr[i]) {
                    return false;
                }
            } else if (arr[i] == '}') {
                if (stack.empty() || stack.pop() != arr[i]) {
                    return false;
                }
            } else if (arr[i] == ')') {
                if (stack.empty() || stack.pop() != arr[i]) {
                    return false;
                }
            }
        }


        return stack.size() == 0;
    }


}
