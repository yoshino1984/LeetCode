package com.yoshino.leetcode.model;

/**
 * @author wangxin
 * 2021/2/21 23:28
 * @since
 **/
class TrieNode {
    private final static int R = 26;
    private TrieNode[] children;
    private boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }

    public boolean containKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }
}
