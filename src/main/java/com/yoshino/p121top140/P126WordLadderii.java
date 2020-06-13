package com.yoshino.p121top140;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 单词接龙
 * fixme 未查找出所有结果
 *
 * @author wangxin
 * 2020/6/11 23:18
 * @since
 **/
public class P126WordLadderii {

    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfs(beginWord, endWord, wordList);
    }

    /**
     * 广度优先bfs
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private List<List<String>> bfs(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, String> wordParentMap = wordList.stream().collect(
            Collectors.toMap(s -> s, s -> "", (s1, s2) -> s2, HashMap::new));
        Set<String> visited = new HashSet<>(wordList.size());
        if (!wordParentMap.containsKey(endWord)) {
            return ans;
        }
        if (beginWord.equals(endWord)) {
            ans.add(Collections.singletonList(beginWord));
            return ans;
        }
        visited.add(beginWord);
        wordParentMap.put(beginWord, "");

        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.pollFirst();
                for (int j = 0; j < cur.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        String newLadder = genNewLadder(cur, j, k + 'a');
                        if (!visited.contains(newLadder) && wordParentMap.containsKey(newLadder)) {
                            if (newLadder.equals(endWord)) {
                                ans.add(genPath(wordParentMap, cur, newLadder));
                            }
                            queue.addLast(newLadder);
                            visited.add(newLadder);
                            wordParentMap.put(newLadder, cur);
                        }
                    }
                }
            }
            if (!ans.isEmpty()) {
                return ans;
            }
        }
        return new ArrayList<>();
    }

    private List<String> genPath(Map<String, String> wordParentMap, String cur, String newLadder) {
        LinkedList<String> path = new LinkedList<>();
        path.add(newLadder);
        path.add(cur);
        while (!"".equals(wordParentMap.get(cur))) {
            cur = wordParentMap.get(cur);
            path.add(cur);

        }
        Collections.reverse(path);
        return path;
    }

    private String genNewLadder(String cur, int i, int newChar) {
        char[] chars = cur.toCharArray();
        chars[i] = (char) newChar;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        new P126WordLadderii().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
//        System.out.println(i);
    }
}
