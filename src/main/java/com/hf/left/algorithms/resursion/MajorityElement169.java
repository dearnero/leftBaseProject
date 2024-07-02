package com.hf.left.algorithms.resursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/2 10:45
 * @version: 1.0
 */
public class MajorityElement169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = ans.getOrDefault(nums[i], 0);
            orDefault++;
            if (orDefault > nums.length / 2){
                return nums[i];
            }
            ans.put(nums[i], orDefault);
        }
        return 0;
    }

    public int majorityElement2(int[] nums){
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                candidate = nums[i];
            }
            count = count + (candidate == nums[i] ? 1 : -1);
        }
        return candidate;
    }

    public int majorityElement3(int[] nums){
        return majorityElement3Rec(nums, 0, nums.length - 1);
    }

    private int majorityElement3Rec(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int half = (r - l) / 2 + l;
        int left = majorityElement3Rec(nums, l, half);
        int right = majorityElement3Rec(nums, half + 1, r);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, l, r);
        int rightCount = countInRange(nums, right, l, r);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
