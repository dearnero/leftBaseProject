package com.hf.left.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 爬楼梯
 * 算法：递归+记忆化搜索 或 动态规划（状态定义、状态转移方程）
 * 状态定义：f(n) 第n阶台阶有多少种不同的方法
 * 状态转移方程：f(n) = f(n -1) + f(n -2)
 * @link <a href = "https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/7/31 09:10
 * @version: 1.0
 */
public class HClimbStairs {
    public int climbStairs(int n) {
        int p = 1, q = 1;
        for (int i = 2; i <= n; i++) {
            int newQ = p  + q;
            p = q;
            q = newQ;
        }
        return q;
    }

    public int climbStairs1(int n) {
        int[] ans = new int[n + 1];
        ans[0] = ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }

    public int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper2(n, memo);
    }

    private int helper2(int n, Map<Integer, Integer> memo){
        if (n <= 1) return 1;
        if (memo.containsKey(n)){
            return memo.get(n);
        }
        int sum = helper2(n - 1, memo) + helper2(n - 2, memo);
        memo.put(n, sum);
        return sum;
    }

    public int climbStairs3(int n) {
        return helper3(n);
    }

    private int helper3(int n){
        if (n == 0 || n == 1) return 1;
        return helper3(n - 1) + helper3(n - 2);
    }

    public static void main(String[] args) {
        new HClimbStairs().climbStairs(5);
    }
}
