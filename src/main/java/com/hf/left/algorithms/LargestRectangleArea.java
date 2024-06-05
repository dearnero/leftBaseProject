package com.hf.left.algorithms;

import java.util.Stack;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/5 09:42
 * @version: 1.0
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        LargestRectangleArea solution = new LargestRectangleArea();
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.calculate02(heights1)); // 输出: 10
    }

    public int calculate02(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;;
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }

    /**
     * 暴力破解
     * @param heights
     *
     */
    public int calculate(int[] heights){
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int i1 = i; i1 < heights.length; i1++) {
                min = Math.min(min, heights[i1]);
                int area = min * (i1 - i + 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public int calculate01(int[] heights){
        return helper(heights, 0, heights.length);
    }

    private int helper(int[] heights, int start, int end){
        if (start == end){
            return 0;
        }
        if (start + 1 == end){
            return heights[start];
        }
        int minIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (heights[i] < heights[minIndex]){
                minIndex = i;
            }
        }
        int area = (end - start) * heights[minIndex];
        int left = helper(heights, start, minIndex);
        int right = helper(heights, minIndex + 1, end);
        int kArea = Math.max(left, right);
        return Math.max(area, kArea);
    }

    public int maximalRectangle(char[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (char[] chars : matrix) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0'){
                    heights[i] = 0;
                }else {
                    heights[i]++;
                }
            }
            maxArea = Math.max(maxArea, calculate02(heights));
        }
        return maxArea;
    }
}
