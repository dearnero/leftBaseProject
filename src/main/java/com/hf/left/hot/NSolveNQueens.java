package com.hf.left.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
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
