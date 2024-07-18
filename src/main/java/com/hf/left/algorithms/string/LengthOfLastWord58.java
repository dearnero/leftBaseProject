package com.hf.left.algorithms.string;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 21:59
 * @version: 1.0
 */
public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        int lastIndex = s.length() -1;
        while (lastIndex > 0 && s.charAt(lastIndex) == ' '){
            lastIndex--;
        }
        int count = 0;
        while (lastIndex >= 0 && s.charAt(lastIndex) != ' '){
            lastIndex--;
            count++;
        }
        return count;
    }
}
