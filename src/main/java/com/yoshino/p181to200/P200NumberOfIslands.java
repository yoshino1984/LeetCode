package com.yoshino.p181to200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * dfs 遍历解法
     * 时间复杂度O(MN) M和N分别为grid的行数和列数
     * 空间复杂度O(MN)
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int ans = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return ans;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    ans++;
//                    dfs(grid, i, j);
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    /**
     * 时间复杂度同dfs，但是需要优先处理1为0，再进行入队
     * @param grid
     * @param i
     * @param j
     */
    private void bfs(char[][] grid, int i, int j) {
        Deque<Integer> deque = new LinkedList<>();
        int nc = grid[0].length;
        deque.addLast(i * nc + j);
        grid[i][j] = '0';
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int k = 0; k < size; k++) {
                int index = deque.pollFirst();
                int row = index / nc;
                int col = index % nc;
                addLand(grid, deque, nc, row + 1, col);
                addLand(grid, deque, nc, row - 1, col);
                addLand(grid, deque, nc, row, col + 1);
                addLand(grid, deque, nc, row, col - 1);
            }
        }
    }

    private void addLand(char[][] grid, Deque<Integer> queue, int nc, int row, int col) {
        if (island(grid, row, col)) {
            grid[row][col] = '0';
            queue.addLast(row * nc + col);
        }
    }

    private boolean island(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length
            && col >= 0 && col < grid[0].length
            && grid[row][col] != '0';
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
            || j < 0 || j >= grid[0].length
            || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

}

