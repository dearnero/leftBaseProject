package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/3 09:45
 * @version: 1.0
 */
public class HTrap {

    public int trap2(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return ans;
    }

    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax =  Math.max(rightMax, height[right]);
            if (height[left] < height[right]){
                ans += leftMax - height[left];
                left++;
            }else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
