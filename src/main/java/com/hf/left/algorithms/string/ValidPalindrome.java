package com.hf.left.algorithms.string;

/**
 * @description:
 *      @link <a href = "https://leetcode.cn/problems/RQku0D/">LCR 019. 验证回文串 II</a>
 * @author: huang fu
 * @date: 2024/7/20 21:31
 * @version: 1.0
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right -1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
