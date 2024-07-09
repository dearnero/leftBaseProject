package com.hf.left.algorithms;

import java.util.Arrays;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/8 10:27
 * @version: 1.0
 */
public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
            }
        }
        return ans[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n){
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[j] = ans[j] + ans[j - 1];
            }
        }
        return ans[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths62().uniquePaths2(3, 3));
    }
}
