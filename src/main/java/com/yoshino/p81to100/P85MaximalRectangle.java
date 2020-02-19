package com.yoshino.p81to100;

public class P85MaximalRectangle {

    /**
     * 动态规划：求解以[i, j]为右下角的最大矩阵
     * 时间复杂度O(N^2 * M)
     * @param matrix
     * @return
     */
    public int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int matrixLength = matrix.length;
        int matrixWidth = matrix[0].length;
        int[][] widthDp = new int[matrixLength + 1][matrixWidth + 1];
        int maxArea = 0;
        // find max width
        for (int i = 1; i <= matrixLength; i++) {
            for (int j = 1; j <= matrixWidth; j++) {
                widthDp[i][j] = matrix[i - 1][j - 1] == '1' ? widthDp[i][j - 1] + 1 : 0;
                int width  = widthDp[i][j];
                for (int i1 = i; i1 >= 0; i1--) {
                    width = Math.min(width, widthDp[i1][j]);
                    if (width == 0 || width * i < maxArea) {
                        break;
                    }
                    maxArea = Math.max(maxArea, width * (i - i1 + 1));
                }
            }
        }
        return maxArea;
    }

}
