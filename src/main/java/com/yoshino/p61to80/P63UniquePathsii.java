package com.yoshino.p61to80;

public class P63UniquePathsii {

    /**
     * 动态规划，时间复杂度O(NM) N*M二维数组
     * 注意坐班的边界值
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0
            || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] nums : obstacleGrid) {
            for (int i = 0; i < width; i++) {
                if (nums[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i - 1];
                }
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0},
            {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1},{0}}));
    }

}
