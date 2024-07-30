package com.hf.left.hot;

import java.util.*;

/**
 * @description: 46. 全排列
 * 算法：回溯算法
 * 1. 假设每个int[nums.length]的每个位置都可以放一个nums数字，但是不能重复
 * 2. 当下推到下一层完成之后，需要清除当前层的状态
 * @link <a href = "https://leetcode.cn/problems/permutations/?envType=study-plan-v2&envId=top-100-liked">46. 全排列</a>
 * @author: huang fu
 * @date: 2024/7/30 12:03
 * @version: 1.0
 */
public class HPermute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList(), ans);
        return ans;
    }

    private void helper(int[] nums, int k, List<Integer> tempAns, List<List<Integer>> ans){
        if (k == nums.length){
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        for (int num : nums) {
            if (!tempAns.contains(num)) {
                tempAns.add(k, num);
                helper(nums, k + 1, tempAns, ans);
                tempAns.remove(k);
            }
        }
    }

    public static void main(String[] args) {
        new HPermute().permute(new int[]{1,2,3});
    }
}
