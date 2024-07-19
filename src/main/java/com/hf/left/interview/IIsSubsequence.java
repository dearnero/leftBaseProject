package com.hf.left.interview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/19 10:34
 * @version: 1.0
 */
public class IIsSubsequence {

    public boolean isSubsequence(String s, String t) {
        Deque<Character> ans = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            ans.offerLast(s.charAt(i));
        }
        ans.offerLast('0');
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == ans.peek()){
                ans.pop();
            }
        }
        return ans.size() == 1;
    }

    public static void main(String[] args) {
        new IIsSubsequence().isSubsequence("abc", "ahbgdc");
    }
}
