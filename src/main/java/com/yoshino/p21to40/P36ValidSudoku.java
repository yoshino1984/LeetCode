package com.yoshino.p21to40;

import java.util.HashSet;
import java.util.Set;

public class P36ValidSudoku {

    /**
     * 1、使用了暴力遍历的方法，大约为3N，时间复杂度为O(N)
     * 2、使用额外存储空间的话，可以在一次遍历时间内完成，时间复杂度还是O(N)
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 验证行
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            characters.clear();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !characters.add(board[i][j])) {
                    return false;
                }
            }
        }
        // 验证列
        for (int i = 0; i < board[0].length; i++) {
            characters.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.' && !characters.add(board[j][i])) {
                    return false;
                }
            }
        }

        // 验证九宫格
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                characters.clear();
                for (int ii = i; ii < i + 3; ii++) {
                    for (int jj = j; jj < j + 3; jj++) {
                        if (board[ii][jj] != '.' && !characters.add(board[ii][jj])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
