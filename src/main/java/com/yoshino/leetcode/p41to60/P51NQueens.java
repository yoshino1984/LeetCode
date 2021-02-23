package com.yoshino.leetcode.p41to60;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class P51NQueens {

    private List<List<String>> ret;
    private int[] array;

    /**
     * N皇后问题，使用回溯算法，递归迭代所有可能性
     * 时间复杂度O(N!)
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        ret = new ArrayList<>();
        array = new int[n];
        solveNQueens(0, n);
        return ret;
    }

    private void solveNQueens(int curIndex, int target) {
        if (curIndex == target) {
            ret.add(print());
            return;
        }
        for (int i = 0; i < target; i++) {
            if (isMatch(curIndex, i)) {
                array[curIndex] = i;
                solveNQueens(curIndex + 1, target);
            }
        }
    }

    private boolean isMatch(int curIndex, int i) {
        for (int index = 0; index < curIndex; index++) {
            if (array[index] == i || array[index] == i + index - curIndex
                || array[index] == i + curIndex - index) {
                return false;
            }
        }
        return true;
    }

    private List<String> print() {
        List<String> retList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < array.length; j++) {
                if (array[i] == j) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }
            retList.add(str.toString());
        }
        return retList;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new P51NQueens().solveNQueens(4)));;
    }

}
