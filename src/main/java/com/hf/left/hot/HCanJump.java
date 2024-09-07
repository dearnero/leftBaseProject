package com.hf.left.hot;

/**
 * @description: 55. 跳跃游戏
 * <a href="https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked">55. 跳跃游戏</>
 * 1. 贪心算法，每一步都计算出能跳出的最大距离
 * 2. 如果最大距离大于数组长度，即返回 true;
 * @author: huang fu
 * @date: 2024/9/7 16:47
 * @version: 1.0
 */
public class HCanJump {

    public boolean canJump(int[] nums) {
        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxStep){
                maxStep = Math.max(maxStep, i + nums[i]);
            }
            if (maxStep >= nums.length - 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new HCanJump().canJump(new int[]{2,3,1,1,4});
    }
}
