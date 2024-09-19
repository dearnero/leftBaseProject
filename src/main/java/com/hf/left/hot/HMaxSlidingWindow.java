package com.hf.left.hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 239. 滑动窗口最大值
 * @link <a href="https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/10 10:24
 * @version: 1.0
 */
public class HMaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[length - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < length; i++) {
            if (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        new HMaxSlidingWindow().maxSlidingWindow(new int[]{7,2, 4}, 2);
    }
}
