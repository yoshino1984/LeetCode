package com.yoshino.leetcode.p41to60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxin
 * 2021/3/15 12:24
 * @since
 **/
public class P54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> result = new ArrayList<>();
        dfs(0, 0, result, matrix, visited, 0);
        return result;
    }

    int[][] dirts = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    private boolean dfs(int row, int col, List<Integer> result, int[][] matrix, boolean[][] visited, int lastDirt) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col]) {
            return false;
        }
        result.add(matrix[row][col]);
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int[] dirt = dirts[(lastDirt + i) % 4];
            if (dfs(row + dirt[0], col + dirt[1], result, matrix, visited, lastDirt + i)) {
                break;
            }

        }
        return true;
    }
}
