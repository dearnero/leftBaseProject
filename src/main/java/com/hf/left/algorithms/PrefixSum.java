package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/27 09:34
 * @version: 1.0
 */
public class PrefixSum {

    public static int[] computePrefixSum(int[] arr){

        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + arr[i - 1];
        }
        return prefixSum;
    }

    public static int rangSum(int[] prefixSum, int l, int r){
        if (l ==0) {
            return prefixSum[0];
        } else {
            return prefixSum[r] - prefixSum[l - 1];
        }
    }
}
