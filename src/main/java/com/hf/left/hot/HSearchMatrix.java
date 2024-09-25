package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/25 10:14
 * @version: 1.0
 */
public class HSearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, down = rows - 1;
        while (top <= down){
            int midRow = top + (down - top) / 2;
            if (matrix[midRow][0] > target){
                down = midRow - 1;
            } else if (matrix[midRow][cols - 1] < target){
                top = midRow + 1;
            } else {
                int left = 0, right = cols - 1;
                while (left <= right){
                    int midCol = left + (right - left)/2;
                    if (matrix[midRow][midCol] == target){
                        return true;
                    } else if (matrix[midRow][midCol] > target){
                        right = midCol - 1;
                    } else {
                        left = midCol + 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
