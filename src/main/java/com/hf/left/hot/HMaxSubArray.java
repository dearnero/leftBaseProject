package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/10 21:40
 * @version: 1.0
 */
public class HMaxSubArray {
    public int maxSubArray(int[] nums) {

        int ans = nums[0];
        int[] dsp = new int[nums.length];
        dsp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dsp[i] = Math.max(dsp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dsp[i]);
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        int ans = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            ans = Math.max(ans, cur);
        }
        return ans;
    }


}
