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
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }
        helper(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void helper(int level, int[] nums, List<Integer> levelList, List<List<Integer>> result){
        if (level == nums.length){
            result.add(levelList);
            return;
        }
        helper(level+1, nums, levelList, result);
        levelList.add(nums[level]);
        helper(level+1, nums, levelList, result);
        levelList.remove(levelList.size()  - 1);
    }

    public static void main(String[] args) {
        new Subsets79().subsets(new int[]{1,2,3});
    }
}
