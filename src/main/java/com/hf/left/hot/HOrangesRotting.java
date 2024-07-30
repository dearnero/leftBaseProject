package com.hf.left.hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @link <a href = "https://leetcode.cn/problems/rotting-oranges/?envType=study-plan-v2&envId=top-100-liked">994. 腐烂的橘子</a>
 * 使用BFS:
 * 1. 首先找到所有的腐败橘子，以及统计到所有的新鲜橘子freshCount
 * 2. 将腐败橘子入队，使用deque
 * 3. 将第一批腐败橘子出队，进行对四周扩散，每扩散一次周期++
 *  3.1 如果周边是新鲜橘子，那么freshCount--，同时入队
 *  3.2 整个过程直到 freshCount==0 或者deque isEmpty
 * 4. 通过判断freshCount == 0, 返回结果
 * @author: huang fu
 * @date: 2024/7/30 09:11
 * @version: 1.0
 */
public class HOrangesRotting {
    public int orangesRotting(int[][] grid) {

        int freshCount = 0, cyclicality = 0;
        Deque<Integer[]> deque = new LinkedList<>();
        // 1. 找到所有腐败橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    freshCount++;
                } else if (grid[i][j] == 2){
                    deque.offerLast(new Integer[]{i, j });
                }
            }
        }
        while (!deque.isEmpty() && freshCount != 0){
            cyclicality++;
            int kk = deque.size();
            for (int i = kk; i > 0; i--) {
                Integer[] pop = deque.pop();
                int r = pop[0], c = pop[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1){
                    grid[r - 1][c] = 2;
                    deque.offerLast(new Integer[]{r - 1, c});
                    freshCount--;
                }
                if (c - 1 >= 0 && grid[r][c - 1]  == 1){
                    grid[r][c - 1] = 2;
                    deque.offerLast(new Integer[]{r, c - 1});
                    freshCount--;
                }
                if (r + 1 < grid.length && grid[r + 1][c]  == 1){
                    grid[r + 1][c] = 2;
                    deque.offerLast(new Integer[]{r+1, c});
                    freshCount--;
                }
                if (c + 1 < grid[0].length && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    deque.offerLast(new Integer[]{r, c+1});
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? cyclicality : -1;
    }

    public static void main(String[] args) {
        new HOrangesRotting().orangesRotting(new int[][]{{1,2}});
    }

}
