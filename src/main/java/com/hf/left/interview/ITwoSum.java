package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/26 18:29
 * @version: 1.0
 */
public class ITwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right){
            if (numbers[left] + numbers[right] == target){
                return new int[]{++left, ++right};
            } else if (numbers[left] + numbers[right] > target){
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
