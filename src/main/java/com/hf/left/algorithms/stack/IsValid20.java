package com.hf.left.algorithms.stack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/23 10:36
 * @version: 1.0
 */
public class IsValid20 {

    public boolean isValid(String s){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            switch (c){
                case "}":
                    if (!stack.isEmpty() && stack.pop().equals("{")){
                        continue;
                    }else {
                        return false;
                    }
                case ")":
                    if (!stack.isEmpty() && stack.pop().equals("(")){
                        continue;
                    }else {
                        return false;
                    }
                case "]":
                    if (!stack.isEmpty() && stack.pop().equals("[")){
                        continue;
                    }else {
                        return false;
                    }
                default:
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static final Map<Character, Character> map = Collections.unmodifiableMap(new HashMap<Character, Character>() {{
        put('{', '}');put('[', ']'); put('(', ')');put('?','?');
    }});

    public boolean isValid2(String s){
        if (s.length() > 0 && !map.containsKey(s.charAt(0))){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)){
                stack.push(c);
            }else if (!map.get(stack.pop()).equals(c)){
                return false;
            }
        }
        return stack.size() == 1;
    }

    public boolean isValid3(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '('){
                stack.push(')');
            }else if (c=='{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        new IsValid20().isValid2("(){}}{");
    }
}
