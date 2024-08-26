package com.hf.left.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/25 21:51
 * @version: 1.0
 */
public class HSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, new ArrayList<>(), ans, nums);
        return ans;
    }

    private void helper(int index, List<Integer> levels, List<List<Integer>> ans, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(levels)); // 这里需要创建新列表以避免引用问题
            return;
        }

        // 不选择当前元素，直接递归
        helper(index + 1, levels, ans, nums);

        // 选择当前元素并递归
        levels.add(nums[index]);
        helper(index + 1, levels, ans, nums);

        // 回溯，撤销选择
        levels.remove(levels.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new HSubsets().subsets(nums);
        System.out.println(result);
    }

}
