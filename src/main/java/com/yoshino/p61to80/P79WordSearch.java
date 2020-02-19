package com.yoshino.p61to80;

import java.util.HashSet;
import java.util.Set;

public class P79WordSearch {

    /**
     * 回溯算法:遍历所有可能性
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        char[] words = word.toCharArray();
        boolean[][] marked = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findExist(board, i, j, words, 0, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findExist(char[][] board, int curi, int curj, char[] word, int wordIndex, boolean[][] marked) {
        if (wordIndex >= word.length) {
            return true;
        }
        String key = curi + ":" + curj;
        if (curi < 0 || curi >= board.length || curj < 0 || curj >= board[0].length
            || board[curi][curj] != word[wordIndex] || marked[curi][curj]) {
            return false;
        }
        marked[curi][curj] = true;
        if (findExist(board, curi + 1, curj, word, wordIndex + 1, marked)) {
            return true;
        }
        if (findExist(board, curi, curj + 1, word, wordIndex + 1, marked)) {
            return true;
        }
        if (findExist(board, curi - 1, curj, word, wordIndex + 1, marked)) {
            return true;
        }
        if (findExist(board, curi, curj - 1, word, wordIndex + 1, marked)) {
            return true;
        }

        marked[curi][curj] = false;
        return false;
    }

}
