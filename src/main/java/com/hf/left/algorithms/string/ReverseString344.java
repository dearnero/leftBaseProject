package com.hf.left.algorithms.string;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/20 10:56
 * @version: 1.0
 */
public class ReverseString344 {
    public void reverseString(char[] s){
        if (s == null || s.length == 0) return;
        int left = 0, right = s.length - 1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
