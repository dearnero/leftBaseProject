package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/23 09:55
 * @version: 1.0
 */
public class IMaxArea {
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right){
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[right] > height[left]){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
