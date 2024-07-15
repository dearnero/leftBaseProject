package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/15 21:14
 * @version: 1.0
 */
public class I21ReverseWords {
    public String reverseWords(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' '){
            l++;
        }
        while (l <= r && s.charAt(r) == ' '){
            r--;
        }
        StringBuilder ans = new StringBuilder();
        int index = r;
        while (index >= l){
            if (s.charAt(index) ==' '){
                ans.append(s, index + 1, r + 1).append(" ");
                while (s.charAt(index) == ' '){
                    index--;
                }
                r = index;
            }
            index--;
        }
        return ans.append(s, l, r + 1).toString().trim();
    }

    public static void main(String[] args) {
        new I21ReverseWords().reverseWords("the sky is blue");
    }
}
