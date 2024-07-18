package com.hf.left.algorithms.sort;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 15:11
 * @version: 1.0
 */
public class QuickSort {

    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int begin, int end){
        if (begin > end){
            return;
        }
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private int partition(int[] arr, int begin, int end){
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]){
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;
        return counter;
    }
}
