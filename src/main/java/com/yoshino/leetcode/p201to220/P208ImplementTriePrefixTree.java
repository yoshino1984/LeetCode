package com.yoshino.leetcode.p201to220;

/**
 * 实现Trie 前缀树
 *
 * @author wangxin
 * 2020/6/30 23:23
 * @since
 **/
public class P208ImplementTriePrefixTree {

}

class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }

        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.get(ch);
            if (node == null) {
                break;
            }
        }

        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.get(ch);
            if (node == null) {
                return false;
            }
        }

        return true;
    }

    class TrieNode{

        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

    }
}
