package com.hf.left.algorithms.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/21 09:08
 * @version: 1.0
 */
public class ThreeNum15 {

    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum > 0){
                    while (lo < hi && nums[hi] == nums[--hi]);
                }else if (sum < 0){
                    while (lo < hi && nums[lo] == nums[++lo]);
                } else {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[hi] == nums[--hi]);
                    while (lo < hi && nums[lo] == nums[++lo]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new ThreeNum15().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
