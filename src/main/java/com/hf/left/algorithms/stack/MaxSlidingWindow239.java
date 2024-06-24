package com.hf.left.algorithms.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/24 17:01
 * @version: 1.0
 */
public class MaxSlidingWindow239 {

    public int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // 窗口未形成
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans[0] = deque.peekFirst();
        // 窗口已形成
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
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
        new MaxSlidingWindow239().maxSlidingWindow(new int[]{1,3,-1,-3,-5,3,6,7}, 3);
    }
}
