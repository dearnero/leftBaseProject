package com.hf.left.interview;

public class I09CanJump {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i <= max){
                max = Math.max(max, i + nums[i]);
                if (max >= length - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
