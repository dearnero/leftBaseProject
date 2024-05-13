package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/13 09:30
 * @version: 1.0
 */
public class HeapDemo {

    private int[] a;

    private int n;

    private int count;

    public HeapDemo(int capacity){
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data){
        if (count >= n)return;
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]){
            // swap(a, i , i/2);
            i = i/2;
        }
    }
}
