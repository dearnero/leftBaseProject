package com.hf.left.hot;

/**
 * @description: 200. 岛屿数量
 * @link <a href="https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * 1. 深度优先算法, 对于目标位置为1的格子，进行前后左右的深度处理
 * @author: huang fu
 * @date: 2024/9/3 14:08
 * @version: 1.0
 */
public class HNumIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ans = 0, rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i, j+1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }

    public static void main(String[] args) {
        char[][] array = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        new HNumIslands().numIslands(array);
    }
}
