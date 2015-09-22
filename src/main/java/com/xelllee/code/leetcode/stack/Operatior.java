package com.xelllee.code.leetcode.stack;

/**
 * Created by xiao on 9/22/15.
 */
public class Operatior {

    interface Operator {
        int eval(int x, int y);
    }

    private String operator;

    private Operatior(String ops) {
        operator = ops;
    }


    public int eval(int x, int y) {

        if (operator.equals("*")) {
            return x * y;
        } else if (operator.equals("/")) {
            return x / y;
        } else if (operator.equals("-")) {
            return x - y;
        } else {
            return x + y;
        }
    }


}
