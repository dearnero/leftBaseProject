package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/11 14:49
 * @version: 1.0
 */
public class MaxProfit123 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[prices.length][3][2];
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] -prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
        }
        return Math.max(0, Math.max(dp[n-1][2][0], dp[n-1][1][0]));
    }
    public int maxProfit2(int[] prices) {

        int n = prices.length;
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }


    public static void main(String[] args) {
        System.out.println(new MaxProfit123().maxProfit(new int[]{1,2,3,4}));
    }
}
