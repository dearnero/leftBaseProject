package com.hf.left.algorithms.string;

/**
 * @description:
 * @link <a href = "https://leetcode.cn/problems/reverse-only-letters/">917. 仅仅反转字母</a>
 * @author: huang fu
 * @date: 2024/7/21 16:00
 * @version: 1.0
 */
public class ReverseOnlyLetters917 {
    public String reverseOnlyLetters(String s) {
        int l = 0, r = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (l < r){
            while (l < r && !Character.isLowerCase(charArray[l]) && !Character.isUpperCase(charArray[l])){
                l++;
            }
            while (l < r && !Character.isLowerCase(charArray[r]) && !Character.isUpperCase(charArray[r])){
                r--;
            }
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
            l++; r--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        new ReverseOnlyLetters917().reverseOnlyLetters("a-bC-dEf-ghIj");
    }
}
