package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/9 16:56
 * @version: 1.0
 */
public class MaxProfit121 {

    public int maxProfit(int[] prices) {
        int[][] ans = new int[prices.length][2];
        ans[0][0] = 0;
        ans[0][1] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            ans[i][0] = Math.max(ans[i-1][0], ans[i-1][1] + prices[i]);
            ans[i][1] = Math.max(ans[i-1][1], - prices[i]);
        }
        return Math.max(ans[prices.length - 1][0], ans[prices.length - 1][1]);
    }

    public static void main(String[] args) {
        new MaxProfit121().maxProfit(new int[]{7,6,4,3,1});
    }
}
