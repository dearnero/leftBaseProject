package com.hf.left.algorithms.string;

/**
 * @description:
 * @link <a href = "https://leetcode.cn/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 * @author: huang fu
 * @date: 2024/7/21 16:41
 * @version: 1.0
 */
public class LongestPalindrome5 {

    private int longest = 1;

    private int beginIndex = 0;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int k = s.length();
        for (int i = 1; i < k; i++) {
            culPalindrome(s, i -1, i);
            culPalindrome(s, i -1, i + 1);
        }
        return s.substring(beginIndex, beginIndex + longest);
    }

    private void culPalindrome(String s, int left , int right){
        while (left >= 0 && right <= s.length() - 1){
            if (s.charAt(left) != s.charAt(right)){
                return;
            }
            int length = right - left + 1;
            if (length > longest){
                longest = length;
                beginIndex = left;
            }
            left--; right++;
        }
    }

    public static void main(String[] args) {
        new LongestPalindrome5().longestPalindrome("aacabdkacaa");
    }
}
