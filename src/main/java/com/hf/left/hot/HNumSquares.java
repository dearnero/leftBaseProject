package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/7 20:49
 * @version: 1.0
 */
public class HNumSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
