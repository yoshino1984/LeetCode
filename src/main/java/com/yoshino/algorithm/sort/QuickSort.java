package com.yoshino.algorithm.sort;

/**
 * @author wangxin
 * 2021/2/23 20:54
 * @since
 **/
public class QuickSort {

    public static void quickSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(a, begin, end);
        quickSort(a, begin, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    private static int partition(int[] a, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                swap(a, counter++, i);
            }
        }
        swap(a, counter, pivot);
        return counter;
    }

    private static void swap(int[] a, int counter, int i) {
        int temp = a[counter];
        a[counter] = a[i];
        a[i] = temp;
    }
}
