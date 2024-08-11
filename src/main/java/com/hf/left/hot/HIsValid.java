package com.hf.left.hot;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/11 11:23
 * @version: 1.0
 */
public class HIsValid {
    public boolean isValid(String s) {
        Map<Character, Character> vaildMap = new HashMap<>();
        vaildMap.put(')','(');
        vaildMap.put(']','[');
        vaildMap.put( '}','{');
        Stack<Character> stack = new Stack<>();
        stack.push('0');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if (!stack.pop().equals(vaildMap.get(c))){
                    return false;
                }
            }
        }
        return stack.peek() == '0';
    }
}
