package com.xelllee.code.leetcode.others3;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockII {


    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 59, 2, 10};

        System.out.println(maxProfit(t));

    }

    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        int max = 0;
        int[] profits = new int[prices.length - 1];

        for (int i = 1; i < prices.length; i++) {
            profits[i - 1] = prices[i] - prices[i - 1];
        }

        for (int p : profits) {
            if (p > 0) {
                max += p;
            }
        }

        return max;
    }


}
