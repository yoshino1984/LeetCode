package com.yoshino.leetcode.p1001to1100;

/**
 * 最大连续1的个数III
 **/
public class P1004MaxConsecutiveOnesiii {

    public int longestOnes(int[] A, int K) {
        int max = 0;
        int zeroCount = 0;
        int left = 0, right = 0;
        while (right < A.length) {
            if (A[right] == 0) {
                zeroCount++;
                if (zeroCount > K) {
                    while (A[left++] != 0);
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
