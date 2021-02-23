package com.yoshino.leetcode.p1101to1200;

/**
 * 数组的相对排序
 **/
public class P1122RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 1001;
        int[] counter = new int[max];
        for (int value : arr1) {
            counter[value]++;
        }

        int index1 = 0;
        int[] ans = new int[arr1.length];
        for (int num2 : arr2) {
            while (counter[num2]-- > 0) {
                ans[index1++] = num2;
            }
        }
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0) {
                ans[index1++] = i;
            }
        }
        return ans;
    }
}
