package com.yoshino.leetcode.p21to40;

import java.util.*;

/**
 * 解数独
 **/
public class P37SudokuSolver {

    public void solveSudoku(char[][] board) {
        List<Character> items = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Set<Character>> rowItemSet = new ArrayList<>(9);
        List<Set<Character>> colItemSet = new ArrayList<>(9);
        List<Set<Character>> modelItemSet = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            rowItemSet.add(new HashSet<>(items));
            colItemSet.add(new HashSet<>(items));
            modelItemSet.add(new HashSet<>(items));
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowItemSet.get(i).remove(board[i][j]);
                    colItemSet.get(j).remove(board[i][j]);
                    int modelSize = i / 3 * 3 + j / 3;
                    modelItemSet.get(modelSize).remove(board[i][j]);
                }
            }
        }

        dfs(board, rowItemSet, colItemSet, modelItemSet, 0);
    }

    private boolean dfs(char[][] board, List<Set<Character>> rowItemSet, List<Set<Character>> colItemSet,
                     List<Set<Character>> modelItemSet, int level) {
        if (level == 81) {
            return true;
        }

        int i = level / 9;
        int j = level % 9;

        if (board[i][j] != '.') {
            return dfs(board, rowItemSet, colItemSet, modelItemSet, level + 1);
        }  else {
            Set<Character> rowItem = rowItemSet.get(i);
            Set<Character> colItem = colItemSet.get(j);
            int modelSize = i / 3 * 3 + j / 3;
            Set<Character> modelItem = modelItemSet.get(modelSize);

            for (char key = '1'; key <= '9'; key++) {
                if (isValid(key, rowItem, colItem, modelItem)) {
                    board[i][j] = key;
                    rowItem.remove(key);
                    colItem.remove(key);
                    modelItem.remove(key);
                    boolean result = dfs(board, rowItemSet, colItemSet, modelItemSet, level + 1);
                    if (result) {
                        return true;
                    } else {
                        board[i][j] = '.';
                        rowItem.add(key);
                        colItem.add(key);
                        modelItem.add(key);
                    }
                }
            }
        }

        return false;
    }

    private boolean isValid(char key, Set<Character> rowItemSet, Set<Character> colItemSet,
                            Set<Character> modelItemSet) {
        return rowItemSet.contains(key) && colItemSet.contains(key) && modelItemSet.contains(key);
    }


    public static void main(String[] args) {
        new P37SudokuSolver().solveSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }
}
