package com.hf.left.hot;

/**
 * @description: 45. 跳跃游戏 II
 * <a href="https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * 1. 定义出边界，及边界范围内最大可跳距离
 * 2. 当循环到达边界之后，统计次数+1
 * 3. 注意遍历数组时，不访问最后一个元素
 * @author: huang fu
 * @date: 2024/9/7 17:02
 * @version: 1.0
 */
public class HJump {

    public int jump(int[] nums) {
        int maxPos = 0, end = 0, ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end){
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new HJump().jump(new int[]{2,3,1,2,4,2,3});
    }
}
