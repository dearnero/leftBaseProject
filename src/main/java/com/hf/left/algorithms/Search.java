package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/16 16:59
 * @version: 1.0
 */
public class Search {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if (right == -1 ){
            return -1;
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[left] < arr[mid]){
                if (arr[left] <= target && target <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid  + 1;
                }
            }else if (arr[left] > arr[mid]){
                if (arr[left] <= target || target <= arr[mid]){
                    right = mid;
                }else {
                    left = mid + 1;
                }
             } else if (arr[left] == arr[mid]){
                if (arr[left] != target){
                    left++;
                }else {
                    right = left;
                }
            }
        }
        return (arr[left] == target) ? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int target = 5;
        System.out.println(new Search().search(arr, target));
    }
}
