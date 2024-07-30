package com.hf.left.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 39. 组合总和
 * 算法: 回溯算法
 * 1. 终止条件：下推层数 == candidates.length
 * 2. 成功条件: target == 0, 代表着凑成了target数字
 * 3. candidates中选择的每个数字可以不选或者重复
 * 4. 下推规则：
 *  4.1 不选当前数字，idx+1，到下一层
 *  4.2 选择当前数组，idx不变，到下一层
 * 5. 下推完成后，移除最近加入数字（仅限4.2的情况）
 * @link <a href= "https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked">39. 组合总和</a>
 * @author: huang fu
 * @date: 2024/7/30 14:03
 * @version: 1.0
 */
public class HCombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, temp, ans, 0);
        return ans;
    }

    private void helper(int[] candidates, int target, List<Integer> temp, List<List<Integer>> ans, int idx){
        if (idx == candidates.length){
            return;
        }
        if (target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        helper(candidates, target, temp, ans, idx + 1);
        if (target - candidates[idx] >= 0){
            temp.add(candidates[idx]);
            helper(candidates, target - candidates[idx], temp, ans, idx);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        new HCombinationSum().combinationSum(new int[]{2,3,6,7}, 7);
    }
}
