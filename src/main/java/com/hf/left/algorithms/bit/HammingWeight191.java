package com.hf.left.algorithms.bit;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/16 14:25
 * @version: 1.0
 */
public class HammingWeight191 {

    public int hammingWeight(int n){
        int count = 0;
        while (n > 0){
            n = n & n -1;
            count++;
        }
        return count;
    }
}

