package com.xelllee.code.leetcode.others;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p/>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {

    public static void main(String[] args) {

        int x = 13;
        int[] table = new int[x];

        System.out.println(shortest(x, table));


    }


    public static int shortest(int x, int[] table) {

        if (table[x - 1] != 0) return table[x - 1];

        double test = Math.sqrt(x);
        int steps = Integer.MAX_VALUE;

        if (test == Math.floor(test)) {
            steps = 1;
        } else {
            for (int i = 1; i < test; i++) {
                int tmp = 1 + shortest(x - i * i, table);
                steps = Math.min(tmp, steps);
            }
        }
        table[x - 1] = steps;
        return steps;
    }


}
