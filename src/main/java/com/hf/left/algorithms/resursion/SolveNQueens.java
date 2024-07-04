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
        boolean[] ding1 = new boolean[2 * n - 1];
        boolean[] ding2 = new boolean[2 * n - 1];
        helper(0, n, cols, usedCols, ding1, ding2, ans);
        return ans;
    }

    private void helper(int r, int n, int[] cols, boolean[] usedCols, boolean[] ding1, boolean[] ding2, List<List<String>> ans) {

        // 终止条件
        if(r == n){
            List<String> oneAns = new ArrayList<>();
            for (int i = 0; i < cols.length; i++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[cols[i]] = 'Q';
                oneAns.add(new String(chars));
            }
            ans.add(oneAns);
        }
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!usedCols[c] && !ding1[r + c] && !ding2[rc]){
                cols[r] = c;
                usedCols[c] = ding1[r + c] = ding2[rc] = true;
                helper(r + 1, n, cols, usedCols, ding1, ding2, ans);
                usedCols[c] = ding1[r + c] = ding2[rc] = false;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(8));
    }

}
