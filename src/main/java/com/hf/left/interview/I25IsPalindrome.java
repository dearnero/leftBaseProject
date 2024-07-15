package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/15 21:55
 * @version: 1.0
 */
public class I25IsPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            while (left < right && (s.charAt(left) == ' ' ||
                    !Character.isLetterOrDigit(s.charAt(left)))){
                ++left;
            }
            while (left < right && (s.charAt(right) == ' ' ||
                    !Character.isLetterOrDigit(s.charAt(right)))){
                --right;
            }
            if (!String.valueOf(s.charAt(left))
                    .equalsIgnoreCase(String.valueOf(s.charAt(right)))){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public static void main(String[] args) {
        new I25IsPalindrome().isPalindrome(".,");
    }
}
