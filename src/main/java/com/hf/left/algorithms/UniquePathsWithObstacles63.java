package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/8 10:45
 * @version: 1.0
 */
public class UniquePathsWithObstacles63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int width = obstacleGrid[0].length;
        int[] ans = new int[width];
        ans[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int[] row : obstacleGrid) {
            for (int i = 0; i < width; i++) {
                if(row[i] == 1){
                    ans[i] = 0;
                } else if (i > 0){
                    ans[i] = ans[i - 1] + ans[i];
                }
            }
        }
        return ans[width - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0},
                {1}
        };
        new UniquePathsWithObstacles63().uniquePathsWithObstacles(grid);
    }
}
