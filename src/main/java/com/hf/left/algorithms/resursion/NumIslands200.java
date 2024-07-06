package com.hf.left.algorithms.resursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/5 15:10
 * @version: 1.0
 */
public class NumIslands200 {

    // 深度优先
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 广度优先
    public int numIslands2(char[][] grid) {

        int ans = 0;
        if (grid == null || grid.length == 0){
            return ans;
        }
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (grid[r][c] == '1'){
                    ++ans;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * colLength + c);
                    while (!neighbors.isEmpty()){
                        int id = neighbors.remove();
                        int row = id / colLength;
                        int col = id % colLength;
                        if (row - 1 > 0 && grid[row - 1][col] == '1'){
                            neighbors.add((row - 1) * colLength + col);
                            grid[row - 1][col] = '0';
                        }
                        if (col - 1 > 0 && grid[row][col - 1] == '1'){
                            neighbors.add(row * colLength + (col - 1));
                            grid[row][col - 1] = '0';
                        }
                        if (row + 1 < rowLength && grid[row + 1][col] == '1'){
                            neighbors.add((row + 1) * colLength + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col + 1 < colLength && grid[row][col + 1] == '1'){
                            neighbors.add(row * colLength + (col + 1));
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(new NumIslands200().numIslands2(grid));
    }
}
