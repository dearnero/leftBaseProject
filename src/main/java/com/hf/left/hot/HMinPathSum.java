package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/11 11:41
 * @version: 1.0
 */
public class HMinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        new HMinPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
}
