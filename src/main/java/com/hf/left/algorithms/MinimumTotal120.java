package com.hf.left.algorithms;

import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/9 11:29
 * @version: 1.0
 */
public class MinimumTotal120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] a = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                a[j] = Math.min(a[j], a[j + 1]) + triangle.get(i).get(j);
            }
        }
        return a[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        return helper(0, 0, triangle);
    }

    private int helper(int level, int col, List<List<Integer>> triangle){
        System.out.println(triangle.size());
        if(level == triangle.size() - 1){
            return triangle.get(level).get(col);
        }
        int cur = triangle.get(level).get(col);
        int left = helper(level + 1, col, triangle);
        int right = helper(level + 1, col + 1, triangle);
        return Math.min(left, right) + cur;
    }
}

