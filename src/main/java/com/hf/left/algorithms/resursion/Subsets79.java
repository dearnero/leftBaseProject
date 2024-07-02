package com.hf.left.algorithms.resursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/1 16:35
 * @version: 1.0
 */
public class Subsets79 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        List<List<Integer>> subsets  = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    private void helper(int index, int[] nums, List<Integer> levels, List<List<Integer>> subsets){
        if (index == nums.length){
            subsets.add(new ArrayList<>(levels));
            return;
        }
        helper(index + 1, nums, levels, subsets);
        levels.add(nums[index]);
        helper(index + 1, nums, levels, subsets);
        // 一定要注意清理当前层数据，避免levels中的值被带到上层
        levels.remove(levels.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Subsets79().subsets(new int[]{1,2}));
    }
}
