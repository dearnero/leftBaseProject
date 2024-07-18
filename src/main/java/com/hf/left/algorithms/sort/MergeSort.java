package com.hf.left.algorithms.sort;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 15:40
 * @version: 1.0
 */
public class MergeSort {

    public int[] sort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void mergeSort(int[] arr, int begin, int right){
        if (begin >= right) return;
        int mid = begin + (right - begin) / 2;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, begin, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int i1 = 0; i1 < temp.length; i1++) {
            arr[left + i1] = temp[i1];
        }
    }
}