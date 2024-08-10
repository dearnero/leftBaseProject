package com.hf.left.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 15. 三数之和
 * 算法: 双指针
 * 1. 对数组进行排序
 * 2. 获取第一数字作为目标值，同时使用双指针对排序后的数组进行相向推进
 *  left: i + 1 ; rigth = length -1;
 * 3. 注意跳过重复数字
 *   跳过1: if (i > 0 && nums[i] == nums[i - 1]) continue;
 *   跳过2: while (left < right && nums[right] == nums[--right]);
 * @link <a href ="https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/4 11:05
 * @version: 1.0
 */
public class HThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] == target) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[--right]);
                    while (left < right && nums[left] == nums[++left]);
                } else if (nums[left] + nums[right] > target){
                    while (left < right && nums[right] == nums[--right]);
                } else {
                    while (left < right && nums[left] == nums[++left]);
                }
            }
        }
        return ans;
    }
}
