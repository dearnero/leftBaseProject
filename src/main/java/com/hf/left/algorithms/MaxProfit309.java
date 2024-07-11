package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/11 18:16
 * @version: 1.0
 */
public class MaxProfit309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1){
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);;
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        new MaxProfit309().maxProfit(new int[]{1,2,3,0,2});
    }
}
