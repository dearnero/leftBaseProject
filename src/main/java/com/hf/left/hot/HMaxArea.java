package com.hf.left.hot;

/**
 * @description: 11. 盛最多水的容器
 * 算法：双指针
 * 1. 首位指针往中间推进
 * @link <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/1 12:06
 * @version: 1.0
 */
public class HMaxArea {

    public int maxArea(int[] height) {
        int lf = 0, rt = height.length - 1, maxArea = Integer.MIN_VALUE;
        while (lf < rt){
            maxArea = Math.max(maxArea, Math.min(height[lf], height[rt]) * (rt - lf));
            if (height[lf] > height[rt]){
                rt--;
            }else {
                lf++;
            }
        }
        return maxArea;
    }
}
