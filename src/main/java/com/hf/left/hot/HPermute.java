package com.hf.left.hot;

import java.util.*;

/**
 * @description: TODO
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
