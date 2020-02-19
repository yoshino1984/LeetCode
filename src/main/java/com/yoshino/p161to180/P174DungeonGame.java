package com.yoshino.p161to180;

public class P174DungeonGame {

    /**
     * 动态规划：（从过去到未来的方式由于 无法确定当前扣除和未来所需生命值哪个重要，因此使用逆推法）
     * dp[i][j]:到终点所需的最小生命值(最小为1 代表至少需要保存有1点生命值) 如果为负代表之后只需要1点生命值即可生存
     * 时间复杂度O(N)N为所有节点的个数
     * 空间复杂度O(1)原地算法 ，如果不改变原有二维数组的话，需要使用一个维数组
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int iMax = dungeon.length;
        int jMax = dungeon[0].length;

        for (int i = iMax - 1; i >= 0; i--) {
            for (int j = jMax - 1; j >= 0; j--) {
                if (i == iMax - 1 && i == jMax - 1) {
                    dungeon[i][j] = 1 - dungeon[i][j];
                } else if (i == iMax - 1) {
                    dungeon[i][j] = dungeon[i][j + 1] -  dungeon[i][j];
                } else if (j == jMax - 1) {
                    dungeon[i][j] = dungeon[i + 1][j] -  dungeon[i][j];
                } else {
                    dungeon[i][j] = Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) -  dungeon[i][j];
                }
                if (dungeon[i][j] <= 0) {
                    dungeon[i][j] = 1;
                }
            }
        }

        return dungeon[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}
