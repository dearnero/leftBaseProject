package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/9 17:24
 * @version: 1.0
 */
public class MaxProfit122 {

    public int maxProfit(int[] prices) {
        int[][] ans = new int[prices.length][2];
        ans[0][0] = 0;
        ans[0][1] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            ans[i][0] = Math.max(ans[i-1][0], ans[i-1][1] + prices[i]);
            ans[i][1] = Math.max(ans[i-1][1], ans[i - 1][0] - prices[i]);
        }
        return ans[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < n; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }



    public static void main(String[] args) {
        System.out.println(new MaxProfit122().maxProfit(new int[]{7,1,5,3,6,4}));;
    }
}
