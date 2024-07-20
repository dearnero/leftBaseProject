package com.hf.left.algorithms.string;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/20 11:01
 * @version: 1.0
 */
public class ReverseStr541 {

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return s;
        char[] ans = s.toCharArray();
        for (int i = 0; i < s.length(); i+=k*2) {
            int left = i;
            int right = i + k > s.length() ? s.length() - 1 : i + k - 1;
            while (left < right && left < s.length()){
                char temp = ans[left];
                ans[left] = ans[right];
                ans[right] = temp;
                left++;
                right--;
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        new ReverseStr541().reverseStr("abcdefg", 3);
    }
}
