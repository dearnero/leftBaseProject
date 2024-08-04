package com.hf.left.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/4 10:47
 * @version: 1.0
 */
public class HTwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (memo.containsKey(target - nums[i])){
                return new int[]{i, memo.get(target - nums[i])};
            }
            memo.put(nums[i], i);
        }
        return nums;
    }
}
