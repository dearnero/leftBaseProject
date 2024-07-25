package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/24 20:25
 * @version: 1.0
 */
public class ICanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n){
            int cnt = 0, sumGas = 0, sumCost = 0;
            while (cnt < n){
                int j = (cnt + i) % n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumGas < sumCost){
                    break;
                }
                cnt++;
            }
            if (cnt == n){
                return i;
            }else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
