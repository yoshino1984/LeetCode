package com.yoshino.p301to350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 回文对
 **/
public class P336PalindromePairs {
    TrieNode root;

    public List<List<Integer>> palindromePairs(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            for (int j = 0; j <= len; j++) {
                if (isPalindrome(words[i], j, len - 1)) {
                    int rightId = findWord(words[i], 0, j - 1);
                    if (rightId != -1 && rightId != i) {
                        ans.add(Arrays.asList(i, rightId));
                    }
                }
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int leftId = findWord(words[i], j, len - 1);
                    if (leftId != -1 && leftId != i) {
                        ans.add(Arrays.asList(leftId, i));
                    }
                }
            }
        }

        return ans;
    }

    private void insert(String s, int id) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            if (node.child[ch - 'a'] == null) {
                node.child[ch - 'a'] = new TrieNode();
            }
            node = node.child[ch - 'a'];
        }
        node.flag = id;
    }

    private int findWord(String word, int left, int right) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (int i = right; i >= left; i--) {
            if (node.child[chars[i] - 'a'] == null) {
                return -1;
            }
            node = node.child[chars[i] - 'a'];
        }
        return node.flag;
    }

    private boolean isPalindrome(String word, int left, int right) {
        while (left >= 0 && right < word.length() && left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    static class TrieNode {
        private final TrieNode[] child;
        private int flag;

        public TrieNode() {
            child = new TrieNode[26];
            flag = -1;
        }
    }
}
