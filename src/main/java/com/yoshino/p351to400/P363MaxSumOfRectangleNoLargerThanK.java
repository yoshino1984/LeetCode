package com.yoshino.p351to400;

/**
 * 矩形区域不超过K的最大数值和
 **/
public class P363MaxSumOfRectangleNoLargerThanK {

    /**
     * 动态规划： (i1,j1)(i2,j2)分别代表矩形的左上角和右下角，四层循环遍历两个坐标点的可能性
     * dp[i1,j1,i2,j2] = dp[i1,j1,i2 - 1,j2] + dp[i1,j1,i2,j2 - 1] - dp[i1,j1,i2 - 1,j2 - 1] + matrix[i2,j2];
     * 时间复杂度O((MN)^2)
     * 空间复杂度O(MN)
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int max = Integer.MIN_VALUE;

        for (int i1 = 1; i1 <= rowLen; i1++) {
            for (int j1 = 1; j1 <= colLen; j1++) {
                int[][] dp = new int[rowLen + 1][colLen + 1];
                for (int i2 = i1; i2 <= rowLen; i2++) {
                    for (int j2 = j1; j2 <= colLen; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] + matrix[i2 - 1][j2 - 1] - dp[i2 - 1][j2 - 1];
                        if (dp[i2][j2] < k && max < dp[i2][j2]) {
                            max = dp[i2][j2];
                        } else if (dp[i2][j2] == k) {
                            return k;
                        }
                    }
                }
            }
        }

        return max;
    }


    public int maxSumSubmatrix1(int[][] matrix, int k) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int max = Integer.MIN_VALUE;

        for (int l = 0; l < colLen; l++) {
            int[] rowSum = new int[rowLen];
            for (int r = l; r < colLen; r++) {
                for (int i = 0; i < rowLen; i++) {
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpMaxLessThanK(rowSum, k));
                if (max == k) {
                    return k;
                }
            }
        }

        return max;
    }

    private int dpMaxLessThanK(int[] rowSum, int k) {
        // O(N)
        int max = dpMax(rowSum);
        if (max <= k) {
            return max;
        }
        // O(N^2)
        max = Integer.MIN_VALUE;
        for (int i = 0; i < rowSum.length; i++) {
            int sum = 0;
            for (int j = i; j < rowSum.length; j++) {
                sum += rowSum[j];
                if (sum <= k && sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private int dpMax(int[] rowSum) {
        int max = Integer.MIN_VALUE;
        int dp = 0;
        for (int num : rowSum) {
            dp = Math.max(0, dp) + num;
            if (dp > max) {
                max = dp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new P363MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix1(
            new int[][]{{2,2,-1}}, 0);
    }
}
