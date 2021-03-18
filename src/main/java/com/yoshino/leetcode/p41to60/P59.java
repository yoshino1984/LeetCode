package com.yoshino.leetcode.p41to60;

/**
 * 控制方向填充结果集
 *
 * @author wangxin
 * @date 2021/3/16 23:47
 */
public class P59 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        dfs(0, 0, 0, n * n, result, 0);
        return result;
    }

    int[][] dirts = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean dfs(int row, int col, int index, int max, int[][] result, int lastDirt) {
        if (index == max) {
            return true;
        }
        if (row < 0 || row >= result.length || col < 0 || col >= result.length || result[row][col] != 0) {
            return false;
        }
        result[row][col] = index + 1;
        for (int i = 0; i < dirts.length; i++) {
            int[] dirt = dirts[(lastDirt + i) % 4];
            if (dfs(row + dirt[0], col + dirt[1], index + 1, max, result, (lastDirt + i) % 4)) {
                break;
            }
        }

        return true;
    }
}
