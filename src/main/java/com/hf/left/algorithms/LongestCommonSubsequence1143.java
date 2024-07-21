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
        int m = text1.length();
        int n = text2.length();
        int[][] ans = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    ans[i][j] = ans[i - 1][j - 1] + 1;
                } else {
                    ans[i][j] = Math.max(ans[i][j - 1], ans[i - 1][j]);
                }
            }
        }
        return ans[m][n];
    }
}
