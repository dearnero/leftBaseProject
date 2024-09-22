package com.hf.left.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 131. 分割回文串
 * <a href ="https://leetcode.cn/problems/palindrome-partitioning/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/22 11:44
 * @version: 1.0
 */
public class HPartition {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(String s, int idx, List<List<String>> ans, List<String> levelAns) {
        if (idx >= s.length()) {
            ans.add(new ArrayList<>(levelAns));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (palindrome(s, idx, i)) { // 判断是否为回文子串
                levelAns.add(s.substring(idx, i + 1)); // 添加当前子串到路径中
                dfs(s, i + 1, ans, levelAns); // 递归到下一个子串
                levelAns.removeLast(); // 回溯，移除最后一个子串
            }
        }
    }

    private boolean palindrome(String s, int lf, int rt) {
        while (lf < rt) {
            if (s.charAt(lf++) != s.charAt(rt--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new HPartition().partition("aab");
    }
}