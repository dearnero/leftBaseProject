package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/8 10:45
 * @version: 1.0
 */
public class UniquePathsWithObstacles63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] ans = new int[n];
        ans[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            ans[i] = (obstacleGrid[0][i] == 1) ? 0 : ans[i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    ans[j] = 0;
                    continue;
                }
                if (j > 0){
                    ans[j] += ans[j - 1];
                }
            }
        }
        return ans[n - 1];
    }
    
    public int uniquePathsWithObstacles2(int[][] obstacleGrid){
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1){
                    dp[j] = 0;
                }else if(j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0},
                {1}
        };
        new UniquePathsWithObstacles63().uniquePathsWithObstacles(grid);
    }
}
