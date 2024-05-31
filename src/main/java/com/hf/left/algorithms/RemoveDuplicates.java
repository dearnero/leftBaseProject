package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/31 09:59
 * @version: 1.0
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // 输入数组
        int[] expectedNums = {1,2}; // 长度正确的期望答案
        new RemoveDuplicates().removeDuplicates(nums);
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
