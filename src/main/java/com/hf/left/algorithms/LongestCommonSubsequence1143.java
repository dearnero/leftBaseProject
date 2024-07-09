package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/9 10:03
 * @version: 1.0
 */
public class LongestCommonSubsequence1143 {

    // 递推数组：
    // 递推公式：
    // 1. if text1(m - 1) != text2(n -1)  LCS(m, n) = max(LCS(m - 1, n), LCS(m, n -1))
    // 2. if text1(m - 1) == text2(n -1)  LCS(m, n) = LCS(m - 1, n - 1) + 1
    public int longestCommonSubsequence(String text1, String text2) {
        int t1 = text1.length();
        int t2 = text2.length();
        int[][] dp = new int[t1 + 1][t2 + 1];
        for (int i = 1; i < dp.length; ++i){
            for(int j = 1; j < dp[0].length; ++j){
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
