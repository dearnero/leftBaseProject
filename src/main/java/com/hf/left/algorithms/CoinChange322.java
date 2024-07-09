package com.hf.left.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/9 15:13
 * @version: 1.0
 */
public class CoinChange322 {

    // 这种递归不行，内存会超
    public int coinChange(int[] coins, int amount) {
        List<Integer> list = new ArrayList<>();
        helper(0, list, amount, coins);
        if (list.isEmpty()){
            return -1;
        } else {
            int min = Integer.MAX_VALUE;
            for (Integer integer : list) {
                min = Math.min(min, integer);
            }
            return min;
        }
    }

    private void helper(int level, List<Integer> list, int surplus, int[] coins){
        if (surplus == 0){
            list.add(level);
        }
        if (surplus < 0){
            return;
        }
        for (int coin : coins) {
            helper(level + 1, list, surplus - coin, coins);
        }
    }

    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] ans = new int[max];
        Arrays.fill(ans, max);
        ans[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i){
                    ans[i] = Math.min(ans[i], ans[i - coins[j]] + 1) ;
                }
            }
        }
        return ans[amount] > amount ? -1 : ans[amount];
    }

    public static void main(String[] args) {
        new CoinChange322().coinChange2(new int[]{1, 2, 5}, 11);
    }
}
