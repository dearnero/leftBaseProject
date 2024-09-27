package com.hf.left.hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 84. 柱状图中最大的矩形
 * 1. 使用单调增栈，保证每个入栈元素都比栈顶大；当出现比栈顶小时，开始进行循环，直到找到比自己小的或空栈
 *  - 因为如果当前元素比栈顶小，那么说明栈顶元素已经无法再扩大面积，即可出栈。面积公式：栈顶高度 * (入栈元素索引 - 当前栈顶元素出栈后的栈顶索引 - 1)
 * 2. 对栈进行初始 -1，保证在最后一个元素出栈后，公式计算正确
 * 3. 当数组循环结束后，需要再对栈进行清空计算
 * <a href= "https://leetcode.cn/problems/largest-rectangle-in-histogram/submissions/568443657/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/27 09:08
 * @version: 1.0
 */
public class HLargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]){
                int popIndex = stack.pop();
                maxArea = Math.max(maxArea, heights[popIndex] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            int popIndex = stack.pop();
            maxArea = Math.max(maxArea, heights[popIndex] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        new HLargestRectangleArea().largestRectangleArea(new int[]{2,4});
    }
}