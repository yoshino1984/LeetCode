package com.yoshino.p61to80;

public class P63UniquePathsii {

    /**
     * 动态规划，时间复杂度O(NM) N*M二维数组
     * 注意坐班的边界值
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int length = obstacleGrid[0].length;
        int[] dp = new int[length + 1];

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 1; j <= length; j++) {
                if (i == 0) {
                    if (j == 1) {
                        dp[j] = obstacleGrid[i][0] == 1 ? 0 : 1;
                    } else {
                        dp[j] = obstacleGrid[i][j - 1] == 1 ? 0 : dp[j - 1];
                    }
                } else {
                    if (j == 1) {
                        dp[j] = obstacleGrid[i][0] == 1 ? 0 : dp[j];
                    } else {
                        dp[j] = obstacleGrid[i][j - 1] == 1 ? 0 : dp[j - 1] + dp[j];
                    }
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0},
            {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1},{0}}));
    }

}
