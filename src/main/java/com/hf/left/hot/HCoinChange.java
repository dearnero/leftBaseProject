package com.hf.left.hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 322. 零钱兑换
 * 算法：递归+记忆化搜索 或 动态规划（状态定义、状态转移方程）
 * 状态定义: ans[i] i金额的最少硬币个数
 * 状态转移方程：ans[i] = Math.min(ans[i], ans[i - coin] + 1)
 *  - 当前金额的最少的硬币个数 = min（当前金额 - coins[0...k] + 1)
 * @link <a href = "https://leetcode.cn/problems/coin-change/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/7/31 11:50
 * @version: 1.0
 */
public class HCoinChange {
//    public int coinChange(int[] coins, int amount) {
//
//    }
    public int coinChange2(int[] coins, int amount) {
        int[] ans = new int[amount + 1];
        Arrays.fill(ans, amount + 1);
        ans[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin){
                    ans[i] = Math.min(ans[i], ans[i - coin] + 1);
                }
            }
        }
        return ans[amount] > amount ? -1 : ans[amount];
    }

    public int coinChange4(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int[] ans = new int[]{Integer.MAX_VALUE};
        helper(coins, amount, ans, 0, new HashMap<>());
        return ans[0] == Integer.MAX_VALUE ? -1:ans[0];
    }

    private void helper(int[] coins, int amount, int[] ans, int count, Map<Integer, Integer> memo){
        if (amount < 0){
            return;
        }
        if (amount == 0){
            ans[0] = Math.min(ans[0], count);
            return;
        }
        if (memo.containsKey(amount) && memo.get(amount) <= count) {
            return;
        }
        memo.put(amount, count);
        for (int coin : coins) {
            helper(coins, amount - coin, ans, count + 1, memo);
        }
    }

    public static void main(String[] args) {
        System.out.println(new HCoinChange().coinChange2(new int[]{1,2,5}, 11));
    }
}
