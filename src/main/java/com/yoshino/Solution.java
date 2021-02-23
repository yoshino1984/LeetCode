package com.yoshino;


/**
 * 刻意练习地方
 **/
class Solution {

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = end, index = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                swap(array, index, i);
                index++;
            }
        }
        swap(array, pivot, index);
        return index;
    }

    private static void swap(int[] array, int index, int i) {
        int temp = array[index];
        array[index] = array[i];
        array[i] = temp;
    }
}
