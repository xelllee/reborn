package com.xelllee.code.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p/>
 * For example, given n = 3, a solution set is:
 * <p/>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {


    public static void main(String[] args) {
        generateParenthesis(1);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        build("(", n, 1, 1, list);
        return list;
    }


    public static void build(String product, int n, int l, int r, List<String> list) {

        if (n == l && r == 0) {
            System.out.println(product);
            list.add(product);
            return;
        }
        if (n > l) {
            build(product + "(", n, l + 1, r + 1, list);
        }
        if (r > 0) {
            build(product + ")", n, l, r - 1, list);
        }
    }
}
