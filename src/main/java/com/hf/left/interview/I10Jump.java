
package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/13 20:33
 * @version: 1.0
 */
public class I10Jump {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPos = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end){
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        new I10Jump().jump(new int[]{2,3,0,1,4});
    }
}
