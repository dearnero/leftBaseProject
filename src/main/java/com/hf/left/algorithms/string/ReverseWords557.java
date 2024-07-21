package com.hf.left.algorithms.string;

/**
 * @description:
 *      @link <a href = "https://leetcode.cn/problems/reverse-words-in-a-string-iii/description/">557. 反转字符串中的单词 III</>
 * @author: huang fu
 * @date: 2024/7/21 15:42
 * @version: 1.0
 */
public class ReverseWords557 {
    public String reverseWords(String s) {
        char[] ans = s.toCharArray();
        int left = 0, k = 0;
        while (k < s.length()){
            if (s.charAt(k) == ' ' || k == s.length() - 1){
                int right = k == s.length() - 1 ? k: k - 1;
                while (left < right){
                    char temp = ans[right];
                    ans[right] = ans[left];
                    ans[left] = temp;
                    left++;
                    right--;
                }
                left = k + 1;
            }
            k++;
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        new ReverseWords557().reverseWords("Mr Ding");
    }
}
