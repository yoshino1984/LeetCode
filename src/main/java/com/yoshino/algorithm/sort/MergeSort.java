package com.yoshino.algorithm.sort;

/**
 * @author wangxin
 * 2021/2/23 20:54
 * @since
 **/
public class MergeSort {

    public static void mergeSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) >> 1;
        mergeSort(a, begin, mid);
        mergeSort(a, mid + 1, end);
        merge(a, begin, mid ,end);
    }

    private static void merge(int[] a, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int index = 0;
        int index1 = begin, index2 = mid + 1;
        while (index1 <= mid && index1 <= end) {
            temp[index++] = a[index1] > a[index2] ? a[index2++] : a[index1++];
        }
        while (index1 <= mid ){
            temp[index++] = a[index1++];
        }
        while (index2 <= end ){
            temp[index++] = a[index2++];
        }
        System.arraycopy(temp, 0, a, begin, temp.length);
    }


}
