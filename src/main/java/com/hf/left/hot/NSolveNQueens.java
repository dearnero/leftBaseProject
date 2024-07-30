package com.hf.left.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 51. N 皇后
 * 回溯算法的经典案例
 * 1. 初始化好结果值，即每一行的列数组
 * 2. 初始化好已使用的列(n)、撇(2*n+1)、捺(2*n+1)
 * 3. 按照行的个数进行下推, 终止条件row == n
 *  3.1 对结果进行按需输出
 * 4. 注意撇规则：row+c都相等，捺规则：row-c都相等
 *  4.1 为了避免捺规则的数组越界，处理为row-c + n -1
 * 5. 当前层的状态置回false
 * @link <a href = "https://leetcode.cn/problems/n-queens/description/?envType=study-plan-v2&envId=top-100-liked">N 皇后</a>
 * @author: huang fu
 * @date: 2024/7/30 14:31
 * @version: 1.0
 */
public class NSolveNQueens {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        int[] cols  = new int[n];
        boolean[] usedCols = new boolean[n];
        boolean[] ding1 = new boolean[2 * n  +1];
        boolean[] ding2 = new boolean[2 * n  +1];
        helper(n, cols, usedCols, ding1, ding2, 0, ans);
        return ans;
    }

    private void helper(int n, int[] cols, boolean[] usedCols, boolean[] ding1, boolean[] ding2, int row, List<List<String>> ans) {
        if (row == n){
            List<String> oneStrList = new ArrayList<>();
            for (int i = 0; i < cols.length; i++) {
                char[] kk = new char[n];
                Arrays.fill(kk, '.');
                kk[cols[i]] = 'Q';
                oneStrList.add(new String(kk));
            }
            ans.add(oneStrList);
        }
        for (int c = 0; c < n; c++) {
            int id2x = row - c + n - 1;
            if (!usedCols[c] && !ding1[row + c] && !ding2[id2x]){
                cols[row] = c;
                usedCols[c] = ding1[row + c] = ding2[id2x] = true;
                helper(n, cols, usedCols, ding1, ding2, row + 1, ans);
                usedCols[c] = ding1[row + c] = ding2[id2x] = false;
            }
        }
    }
}
