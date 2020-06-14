package com.yoshino.model;

import java.util.*;

/**
 * 刻意练习地方
 *
 * @author wangxin
 * 2020/6/11 20:51
 * @since
 **/
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Deque<String> deque = new LinkedList<>();
        deque.add(beginWord);
        wordSet.remove(beginWord);

        int count = 1;
        while (!deque.isEmpty()) {
            count++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String cur = deque.pollFirst();
                for (int j = 0; j < cur.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        String newGen = genLadder(cur, j, 'a' + k);
                        if (newGen.equals(endWord)) {
                            return count;
                        } else if (wordSet.remove(newGen)) {
                            deque.addLast(newGen);
                        }
                    }
                }
            }
        }

        return 0;
    }

    private String genLadder(String cur, int i, int newChar) {
        char[] chars = cur.toCharArray();
        chars[i] = (char) newChar;
        return String.valueOf(chars);
    }

}
