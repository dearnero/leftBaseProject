package com.hf.left.hot;


/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/6 16:45
 * @version: 1.0
 */
public class HMaxProfit {

    /**
     * 一次买卖
     * 使用动态规划的解法
     */
    public int maxProfit11(int[] prices) {
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], - prices[i]);
        }
        return dp[0];
    }

    /**
     * 一次买卖
     * 使用贪心算法(仅限于一次买卖)
     * 1. 找到维护最小值，找到最大值
     */
    public int maxProfit12(int[] prices) {
        int minProfit = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minProfit){
                minProfit = prices[i];
            } else if (prices[i] - minProfit > maxProfit){
                maxProfit = prices[i] - minProfit;
            }
        }
        return maxProfit;
    }

    /**
     * 不限次数买卖
     */
    public int maxProfit21(int[] prices) {
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }
}
