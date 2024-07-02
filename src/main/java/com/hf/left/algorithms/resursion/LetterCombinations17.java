package com.hf.left.algorithms.resursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/1 16:56
 * @version: 1.0
 */
public class LetterCombinations17 {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return ans;
        }
        Map<Character, String> dirt = new HashMap<>();
        dirt.put('2', "abc");
        dirt.put('3', "def");
        dirt.put('4', "ghi");
        dirt.put('5', "jkl");
        dirt.put('6', "mno");
        dirt.put('7', "pqsr");
        dirt.put('8', "tuv");
        dirt.put('9', "wxyz");
        helper(digits, "", ans, 0 ,dirt);
        return ans;
    }

    private void helper(String digits, String str, List<String> ans, int index, Map<Character, String> dirt){
        if (index == digits.length()){
            ans.add(str);
            return;
        }
        char c = digits.charAt(index);
        for (char c1 : dirt.get(c).toCharArray()) {
            helper(digits, str + c1, ans, index + 1, dirt);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations17().letterCombinations("23"));
    }
}
