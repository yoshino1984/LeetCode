package com.yoshino.leetcode.P801to900;

public class P896 {

    public boolean isMonotonic(int[] A) {
        boolean isIncrease = A[A.length - 1] >= A[0];

        for (int i = 1; i < A.length; i++) {
            if (isIncrease) {
                if (A[i - 1] > A[i]) {
                    return false;
                }
            } else {
                if (A[i - 1] < A[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
