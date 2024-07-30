package com.hf.left.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 560. 和为 K 的子数组
 * 算法：前缀和
 * 1. 使用一个map来保存前缀和的个数（可能出现多个）
 * 2. 每次判断，通过当前的前缀和-k, 看看在map中是否存在
 * 3. map在初始化的时候，使用temp.put(0,1),这种方式很精巧，为了兼容n1+n2+...+ni = k的情况
 * 注意：一开始使用了排序+双指针的方式，测试用例中包含了负数，该算法失败
 * @link <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked">560. 和为 K 的子数组</a>
 * @author: huang fu
 * @date: 2024/7/29 15:56
 * @version: 1.0
 */
public class HSubarraySum {

    // nums = [1,2,3], k = 3
    // preSum = [1,3,6]

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> temp = new HashMap<>();
        temp.put(0, 1);
        int ans = 0, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (temp.containsKey(preSum - k)){
                ans += temp.get(preSum - k);
            }
            temp.put(preSum, temp.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
    public int subarraySum4(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) ans++;
            }
        }
        return ans;
    }


    public int subarraySum2(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) ans++;
            }
        }
        return ans;
    }

        // [1,2,1,2,1] k =3
    public int subarraySum3(int[] nums, int k) {
        int left = 0, right = 0, ans = 0, sum = 0;
        while (right < nums.length){
            sum += nums[right];
            if (sum == k){
                ans++;
            } else if (sum > k){
                while (sum > k && left < right){
                    sum-=nums[left];
                    left++;
                }
                if (sum == k) ans++;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new HSubarraySum().subarraySum(new int[]{1,1,2,3}, 5);
    }
}
