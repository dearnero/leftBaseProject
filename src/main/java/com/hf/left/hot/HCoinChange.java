package com.hf.left.hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
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
        System.out.println(new HCoinChange().coinChange4(new int[]{1,2,5}, 11));
    }
}
