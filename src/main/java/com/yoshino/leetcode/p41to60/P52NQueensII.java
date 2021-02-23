package com.yoshino.leetcode.p41to60;

import java.util.concurrent.atomic.AtomicInteger;

public class P52NQueensII {

    public int totalNQueens(int n) {
        AtomicInteger ans = new AtomicInteger();
        int[] placed = new int[n];
        dfs(placed, 0, n, ans);
        return ans.get();
    }

    private void dfs(int[] placed, int curRow, int maxLevel, AtomicInteger ans) {
        if (curRow == maxLevel) {
            ans.incrementAndGet();
        }

        for (int i = 0; i < maxLevel; i++) {
            if (isValid(placed, curRow, i)) {
                placed[curRow] = i;
                dfs(placed, curRow + 1, maxLevel, ans);
            }
        }

    }

    private boolean isValid(int[] placed, int curLevel, int i) {
        for (int row = 0; row < curLevel; row++) {
            if (placed[row] == i || placed[row] == i + row - curLevel || placed[row] == i + curLevel - row) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        new P52NQueensII().totalNQueens(4);
        System.out.println(new Solution().totalNQueens(4));
    }


    /**
     * bit 方式计数
     */
    static class Solution {
        private int size;
        private int count;
        private void solve(int col, int pie, int na) {
            if (col == size) {
                count++;
                return;
            }
            int pos = size & (~(col | pie | na));
            while (pos != 0) {
                int p = pos & (-pos);
                pos -= p; // pos &= pos - 1;
                solve(col | p, (pie | p) << 1, (na | p) >> 1);
            }
        }

        public int totalNQueens(int n) {
            count = 0;
            size = (1 << n) - 1;
            System.out.println(size);
            solve(0, 0, 0);
            return count;
        }
    }

}
