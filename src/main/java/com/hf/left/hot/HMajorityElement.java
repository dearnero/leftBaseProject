package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/24 20:56
 * @version: 1.0
 */
public class HMajorityElement {

    public int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0){
                majority = nums[i];
            }
            count += majority == nums[i] ? 1:-1;
        }
        return majority;
    }
}
