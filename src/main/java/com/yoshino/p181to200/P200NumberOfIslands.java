package com.yoshino.p181to200;

public class P200NumberOfIslands {

    /**
     * 使用贪心思想进行递归迭代，时间复杂度为O(N) 遍历所有元素
     * 使用了2来标记遍历过的1，这样就避免了重复判断（如果不允许变更，可以使用一set防止重复访问）
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] gridCloum = grid[i];
            for (int j = 0; j < gridCloum.length; j++) {
                if (gridCloum[j] == '1') {
                    count++;
                    infect(grid, i, j);
                }
            }
        }
        return count;
    }

    private void infect(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }
}

