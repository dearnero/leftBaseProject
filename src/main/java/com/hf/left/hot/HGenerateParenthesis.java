package com.hf.left.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/1 15:33
 * @version: 1.0
 */
public class HGenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, 0, n, ans, "");
        return ans;
    }

    private void helper(int left, int right, int n, List<String> ans, String parenthesis){
        // 递归终止条件
        if (left == n && right == n){
            ans.add(parenthesis);
            return;
        }
        // 处理当前层 & 递归下一层
        if (left < n){
            helper(left + 1, right, n, ans, parenthesis + "(");
        }
        if (right < left){
            helper(left, right + 1, n, ans, parenthesis + ")");
        }
        // 清理状态
    }

    public static void main(String[] args) {
        new HGenerateParenthesis().generateParenthesis(1);
    }
}
