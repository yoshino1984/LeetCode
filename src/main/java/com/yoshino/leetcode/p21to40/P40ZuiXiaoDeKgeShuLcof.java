package com.yoshino.leetcode.p21to40;

import com.yoshino.leetcode.model.ListNode;

import java.util.*;

public class P40ZuiXiaoDeKgeShuLcof {

    /**
     * 排序方法
     * 时间复杂度O(NlogN)
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ret = new int[k];
        System.arraycopy(arr, 0, ret, 0, k);
        return ret;
    }

    public static void main(String[] args) {
    }
}
