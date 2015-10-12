package com.xelllee.code.sf;

import java.util.Stack;

/**
 * write program to find wrong number of "(()" parenthesis in expression "((B+a)"
 * give error for "((A))" - for unnecessary brackets
 */
public class Q2 {

    public static void main(String[] args) {


    }


    public static boolean validate(String s) {

        char[] arr = s.toCharArray();

        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < arr.length; i++) {

            char t = arr[i];

            if (t == '}' && stack.isEmpty()) {
                return false;
            } else if (t == '}' && stack.peek().equals("{")) {
                stack.pop();
            }


        }


        return false;
    }


}
