package com.hf.left.algorithms.resursion;

import java.util.*;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/1 17:23
 * @version: 1.0
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        int[] cols = new int[n];
        boolean[] usedCols = new boolean[n];
        boolean[] ding1 = new boolean[n * 2 - 1];
        boolean[] ding2 = new boolean[n * 2 - 1];
        helper(0, n, cols, usedCols, ding1, ding2, ans);
        return ans;
    }

    private void helper(int row, int n, int[] cols, boolean[] usedCols, boolean[] ding1, boolean[] ding2, List<List<String>> ans){
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
            int ding2Index = row - c + n - 1;
            if (!usedCols[c] && !ding1[row + c] && !ding2[ding2Index]){
                cols[row] = c;
                usedCols[c] = ding1[row + c] = ding2[ding2Index] = true;
                helper(row + 1, n, cols, usedCols, ding1, ding2, ans);
                usedCols[c] = ding1[row + c] = ding2[ding2Index] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(4));
    }

}
