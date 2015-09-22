package com.xelllee.code.leetcode.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

/*

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  ["4", "13", "5", "/","13", "5", "/","*","+"] -> (4 +(13 / 5) * (13 / 5)) -> 8

Example Questions Candidate Might Ask:
Q: Is an empty array a valid input? A: No.
* */


    private static final Set<String> OPERATORS =
            new HashSet<String>(Arrays.asList("+", "-", "*", "/"));

    public static void main(String[] args) {

        String[] t = {"4", "5", "13", "5", "/", "13", "5", "/", "*", "+", "+"};
        String[] t1 = {};

        System.out.println(evalRPN2(t1));

    }

    public int evalRPN(String[] tokens) {

        int res = 0, b, a;

        //valid express at least should len == 3;
        if (tokens == null || tokens.length == 0 || tokens.length == 2) return res;
        else {
            Stack<Integer> stack = new Stack<Integer>();
            for (String s : tokens) {
                if (OPERATORS.contains(s)) {
                    b = stack.pop();
                    a = stack.pop();
                    res = eval(a, b, s);
                    stack.push(res);
                } else {
                    stack.push(Integer.parseInt(s));
                }
            }
            return stack.pop();
        }

    }


    private static int eval(int x, int y, String operator) {

        if (operator.equals("+")) {
            return x + y;
        } else if (operator.equals("-")) {
            return x - y;
        } else if (operator.equals("*")) {
            return x * y;
        } else {
            return x / y;
        }
    }

    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(eval(x, y, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
