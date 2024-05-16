package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/16 11:27
 * @version: 1.0
 */
public class SelectionSort {

    private SelectionSort(){}

    public static void sort(int[] arr){
       for (int i = 0; i < arr.length - 1; ++i){
           int minIndex = i;
           for (int j = i + 1; j < arr.length; ++j){
               if (arr[j] < arr[minIndex]){
                   minIndex = j;
               }
           }
           // swap
           int temp = arr[minIndex];
           arr[minIndex] = arr[i];
           arr[i] = temp;
       }
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i++ ){
            System.out.println(arr[i]);
        }
    }

}