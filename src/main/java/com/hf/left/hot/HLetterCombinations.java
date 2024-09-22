package com.hf.left.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/22 09:21
 * @version: 1.0
 */
public class HLetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isBlank()) return ans;
        Map<Character, String> dirt = new HashMap<>();
        dirt.put('2', "abc");
        dirt.put('3', "def");
        dirt.put('4', "ghi");
        dirt.put('5', "jkl");
        dirt.put('6', "mno");
        dirt.put('7', "pqsr");
        dirt.put('8', "tuv");
        dirt.put('9', "wxyz");
        dfs(digits, dirt, ans, 0, "");
        return ans;
    }

    private void dfs(String digits, Map<Character, String> dirt, List<String> ans, int idx, String val) {
        if (idx >= digits.length()){
            ans.add(val);
            return;
        }
        String strs = dirt.get(digits.charAt(idx));
        for (int i = 0; i < strs.length(); i++) {
            dfs(digits, dirt, ans, idx + 1, val + strs.charAt(i));
        }
    }

    public static void main(String[] args) {
        new HLetterCombinations().letterCombinations("23");
    }
}
