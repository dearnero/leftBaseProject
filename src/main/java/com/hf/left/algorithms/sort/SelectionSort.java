package com.hf.left.algorithms.sort;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 14:59
 * @version: 1.0
 */
public class SelectionSort {
    public int[] sort(int[] arr) {

        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
}
