package com.yoshino.leetcode.p301to350;


public class P304 {

}

class NumMatrix {

    public int[][] subSumMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        subSumMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    subSumMatrix[i][j] = matrix[i][j];
                } else {
                    subSumMatrix[i][j] = subSumMatrix[i][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += subSumMatrix[i][col2] - (col1 == 0 ? 0 : subSumMatrix[i][col1 - 1]);
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */