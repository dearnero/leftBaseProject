package com.hf.left.algorithms.sort;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 15:06
 * @version: 1.0
 */
public class BubbleSort {
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] =  temp;
                }
            }
        }
        return arr;
    }
}