package com.yoshino.leetcode.p951to1000;

import java.util.Deque;
import java.util.LinkedList;

public class P995MinimumNumberOfKConsecutiveBitFlips {

    public int minKBitFlips(int[] A, int K) {
        Deque<Integer> que = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (que.size() > 0 && que.peek() + K - 1 < i) {
                que.removeFirst();
            }
            if (que.size() % 2 == A[i]) {
                if (i + K > A.length) {
                    return -1;
                }
                res++;
                que.add(i);
            }
        }

        return res;
    }
}
