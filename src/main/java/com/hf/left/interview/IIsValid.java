package com.hf.left.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/16 09:18
 * @version: 1.0
 */
public class IIsValid {

    public boolean isValid(String s) {
        Map<Character, Character> temp = new HashMap<>();
        temp.put(')', '(');
        temp.put('}', '{');
        temp.put(']', '[');
        Stack<Character> ans = new Stack<>();
        ans.push('0');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                ans.push(c);
            } else {
                if (!temp.get(c).equals(ans.pop())){
                    return false;
                }
            }
        }
        return ans.peek() == '0';
    }
}
