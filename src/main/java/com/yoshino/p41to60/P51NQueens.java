package com.yoshino.p41to60;

import java.util.ArrayList;
import java.util.List;

public class P51NQueens {

    /**
     * N皇后问题，使用回溯算法，递归迭代所有可能性
     * 时间复杂度O(N!)
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[] array = new int[n];
        nQueens(array, 0,  n);
        return res;
    }

    static List<List<String>> res;
    private void nQueens(int[] array, int i, int n) {
        if (i == n) {
            res.add(print(array));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isMatch(array, i, j)) {
                array[i] = j;
                nQueens(array, i + 1, n);
            }
        }
    }

    private List<String> print(int[] array) {
        List<String> res = new ArrayList<>();
        for (int index : array) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                if (i == index) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            res.add(stringBuilder.toString());
        }
        return res;
    }

    private boolean isMatch(int[] array, int i, int j) {
        for (int index = 0; index < i; index++) {
            if (array[i - index - 1] == j || array[i - index - 1] == j + 1 + index
                || array[i - index - 1] == j - 1 - index ) {
                return false;
            }
        }
        return true;
    }

}
