package com.hf.left.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
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
