package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/11 16:50
 * @version: 1.0
 */
public class MaxProfit188 {

    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        if (k >= n / 2){
            int maxP = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]){
                    maxP += (prices[i] - prices[i - 1]);
                }
            }
            return maxP;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
            sell[i] = 0;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <=k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }
        return sell[k];
    }
}
