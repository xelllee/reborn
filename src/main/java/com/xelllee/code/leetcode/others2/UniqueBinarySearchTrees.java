package com.xelllee.code.leetcode.others2;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p/>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBinarySearchTrees {


    public static void main(String[] args) {

//        int[][] table = new int[2][2];
//        System.out.println(table[0][1]);
        System.out.println(numTrees(15));
    }

    public static int numTrees(int n) {
        int[][] table = new int[n + 1][n + 1];
        return build(1, n, table);

    }

    public static int build(int s, int e, int[][] t) {

        int counter = 0;
        if (e <= s) return 1;
        if (t[s][e] != 0) return t[s][e];
        else {
            for (int i = s; i <= e; i++) {
                counter += (build(s, i - 1, t) * build(i + 1, e, t));
            }
            t[s][e] = counter;
        }
        return counter;
    }

    public static int numTrees2(int n) {
        int[] count = new int[n + 1];

        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                count[i] = count[i] + count[j] * count[i - j - 1];
            }
        }

        return count[n];
    }


}
