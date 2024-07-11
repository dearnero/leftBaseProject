package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/11 20:14
 * @version: 1.0
 */
public class I05MajorityElement {

    public int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                majority = nums[i];
            }
            count += (majority == nums[i]) ? 1:-1;
        }
        return majority;
    }
}
