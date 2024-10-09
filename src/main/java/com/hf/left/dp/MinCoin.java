package com.hf.left.dp;

import java.util.Arrays;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/10/9 10:43
 * @version: 1.0
 */
public class MinCoin {

    /**
     * 下述代码完全使用贪心的思路，每次取局部最优解，适用于小部分场景
     * 但无法解决所有问题
     */
    int getMinCoinHelper(int total, int[] values, int valueCount){
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            int val = values[i];
            int currentCount = total / val;
            total -= currentCount * val;
            count += currentCount;
        }
        return total == 0 ? count : -1;
    }

    /**
     * 下述代码使用回溯+贪心的方式
     */
    int getMinCoinHelper2(int total, int[] values){
        Arrays.sort(values);
        return backtrack(values, total, values.length - 1);
    }

    int backtrack(int[] coins, int remaining, int index){
        if (remaining == 0) return 0;
        if (index < 0) return -1;
        int maxCoins = remaining / coins[index];
        for (int i = maxCoins; i >= 0; i--) {
            int newRemaining = remaining - i * coins[index];
            if (newRemaining >=  0){
                int result = backtrack(coins, newRemaining, index - 1);
                if (result != -1){
                    return i + result;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MinCoin().getMinCoinHelper2(11, new int[]{1, 2, 5}));
        new MinCoin().getMinCoinHelper(10, new int[]{5, 3}, 2);
        new MinCoin().getMinCoinHelper(11, new int[]{5, 3, 1}, 3);
    }

}
