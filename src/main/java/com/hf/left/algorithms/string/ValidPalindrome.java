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
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return isPalindrome(s, low, high - 1) || isPalindrome(s, low + 1, high);
            }
        }
        return true;
    }
    public boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
