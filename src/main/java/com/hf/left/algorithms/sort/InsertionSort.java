package com.hf.left.algorithms.sort;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 14:44
 * @version: 1.0
 */
public class InsertionSort {

    public int[] sort(int[] arr){
        int length = arr.length;
        int preIndex, current;
        for (int i = 1; i < length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
         }
        return arr;
    }
}
