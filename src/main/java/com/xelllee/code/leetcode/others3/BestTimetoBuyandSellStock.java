package com.xelllee.code.leetcode.others3;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimetoBuyandSellStock {


    public static void main(String[] args){
        int[] t = {1,2,3,4,59,2};

        System.out.println(maxProfit2(t));
    }

    public static int maxProfit(int[] prices) {


        if (prices == null || prices.length < 2) return 0;

        int max = 0;
        int tmp = 0;
        int[] profits = new int[prices.length - 1];

        for (int i = 1; i < prices.length; i++) {
            profits[i - 1] = prices[i] - prices[i - 1];
        }

        for (int p : profits) {
            tmp += p;
            tmp = Math.max(0, tmp);
            max = Math.max(tmp, max);
        }

        return max;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            profit = Math.max(profit, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
