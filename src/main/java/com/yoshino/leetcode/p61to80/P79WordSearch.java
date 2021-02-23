package com.yoshino.leetcode.p61to80;


public class P79WordSearch {
    static int[][] dirt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 时间复杂度
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existInner(0, i, j, board, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existInner(int index, int row, int col, char[][] board, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
            || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;

        for (int[] ints : dirt) {
            if (existInner(index + 1, row + ints[0], col + ints[1], board, word, visited)) {
                return true;
            }
        }
        visited[row][col] = false;

        return false;
    }

}
