package com.yoshino.p121top140;

import java.util.*;

/**
 * 单词接龙
 *
 * @author wangxin
 * 2020/6/11 23:18
 * @since
 **/
public class P127WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfs(beginWord, endWord, wordList);
    }

    /**
     * 广度优先bfs
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        wordSet.remove(beginWord);
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.pollFirst();
                for (int j = 0; j < cur.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        String newLadder = genNewLadder(cur, j, k + 'a');
                        if (wordSet.remove(newLadder)) {
                            if (newLadder.equals(endWord)) {
                                return count;
                            }
                            queue.addLast(newLadder);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private String genNewLadder(String cur, int i, int newChar) {
        char[] chars = cur.toCharArray();
        chars[i] = (char) newChar;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        int i = new P127WordLadder().ladderLength("hit", "hit", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(i);
    }
}
