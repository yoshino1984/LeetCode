package com.yoshino.p121top140;


/**
 * 被围绕的区域
 **/
public class P130SurroundedRegions {

    /**
     * dfs解法，两次遍历染色
     * 时间复杂度O(MN)
     * 空间复杂度O(1)
     * @param board
     */
    public void solve(char[][] board) {
        char color = '@';
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j, color);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == color){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, char color) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = color;
        dfs(board, i + 1, j, color);
        dfs(board, i - 1, j, color);
        dfs(board, i, j + 1, color);
        dfs(board, i, j - 1, color);
    }

    /**
     * 并查集解法
     *
     */
    public void solve2(char[][] board) {

    }


}
