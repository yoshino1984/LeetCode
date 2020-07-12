package com.yoshino.model;


import java.util.*;

/**
 * 刻意练习地方
 **/
class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }

        Set<String> ans = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsFind(root, board, i, j, "", ans);
            }
        }

        return new ArrayList<>(ans);
    }

    private void dfsFind(TrieNode root, char[][] board, int i, int j, String path, Set<String> ans) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '@'
            || !root.containKey(board[i][j])) {
            return;
        }

        char key = board[i][j];
        board[i][j] = '@';
        TrieNode node = root.get(key);
        path += key;
        if (node.isWord()) {
            ans.add(path);
        }
        dfsFind(node, board, i + 1, j, path, ans);
        dfsFind(node, board, i - 1, j, path, ans);
        dfsFind(node, board, i, j + 1, path, ans);
        dfsFind(node, board, i, j - 1, path, ans);

        board[i][j] = key;
    }

    private void insert(TrieNode root, String word) {
        for (char ch : word.toCharArray()) {
            if (!root.containKey(ch)) {
                root.put(ch, new TrieNode());
            }
            root = root.get(ch);
        }

        root.setWord(true);
    }

    class TrieNode {
        private final int R = 26;

        private TrieNode[] child;

        private boolean isWord;

        public TrieNode() {
            this.child = new TrieNode[26];
        }

        public boolean containKey(char ch) {
            return child[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return child[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            child[ch - 'a'] = node;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}};
        String[] strings = new String[] {"oath","pea","eat","rain"};
        new Solution().findWords(board, strings);
    }
}
