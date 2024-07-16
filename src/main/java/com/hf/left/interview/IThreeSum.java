package com.hf.left.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/16 09:02
 * @version: 1.0
 */
public class IThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) return ans;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r  = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0){
                    while (l < r && nums[r] == nums[--r]);
                }else if (sum < 0){
                    while (l < r && nums[l] == nums[++l]);
                }else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r] == nums[--r]);
                    while (l < r && nums[l] == nums[++l]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new IThreeSum().threeSum(new int[]{0,0,0,0});
    }
}
