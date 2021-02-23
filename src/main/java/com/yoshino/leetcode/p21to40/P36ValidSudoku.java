package com.yoshino.leetcode.p21to40;

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


    public static void main(String[] args) {
        char[][] chars = new char[][]{{'5','3','4','6','7','8','1','9','2'},{'6','7','2','1','9','5','3','4','8'},{'1','9','8','3','4','2','5','6','7'},{'8','5','9','7','6','1','4','2','3'},{'4','2','6','8','5','3','9','7','1'},{'7','1','3','9','2','4','8','5','6'},{'9','6','1','5','3','7','2','8','4'},{'2','8','7','4','1','9','6','3','5'},{'3','4','5','2','8','6','7','7','9'}};
        System.out.println(new P36ValidSudoku().isValidSudoku(chars));
    }
}
