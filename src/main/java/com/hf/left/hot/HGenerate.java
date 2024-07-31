package com.hf.left.hot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 杨辉三角
 * 算法：动态规划
 * 状态定义：f(n)(j) 当前行列位置的值
 * 状态转移方式：
 * if(j == 0 || j ==i) {
 *     f(n)(j) = 1
 * } else {
 *     f(n)(j) = f(n - 1)(j - 1) + f(n - 1)(j)
 * }
 * @link <a href="https://leetcode.cn/problems/pascals-triangle/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/7/31 09:46
 * @version: 1.0
 */
public class HGenerate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(0, Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> levels = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    levels.add(1);
                } else {
                    levels.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(levels);
        }
        return ans;
    }

    public static void main(String[] args) {
        new HGenerate().generate(2);
    }
}
