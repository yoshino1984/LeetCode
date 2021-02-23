package com.yoshino.leetcode.p1001to1100;

/**
 * 最佳观光组合
 *
 * @author wangxin
 * 2020/6/17 23:53
 * @since
 **/
public class P1014BestSightseeingPair {

    /**
     * 评分标准为 A[i] + A[j] + i - j，可以分为两个数组 A[i] + i 和 A[j] - j
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int maxPlus = A[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i] - i + maxPlus);
            maxPlus = Math.max(maxPlus, A[i] + i);
        }

        return max;
    }
}
