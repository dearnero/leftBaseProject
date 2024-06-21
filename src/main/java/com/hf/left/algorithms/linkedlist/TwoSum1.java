package com.hf.left.algorithms.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/21 08:59
 * @version: 1.0
 */
public class TwoSum1 {

    public int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.get(target - nums[i]) != null){
                return new int[]{i, result.get(target - nums[i])};
            }
            result.put(nums[i],i);
        }
        return null;
    }
}
