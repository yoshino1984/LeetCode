package com.yoshino.P401to450;

import java.util.*;

/**
 * 最小基因变化
 *
 * @author wangxin
 * 2020/6/11 22:23
 * @since
 **/
public class P433MinimumGeneticMutation {

    /**
     * BFS：从start状态可以扩展出更多的状态层，遍历每一层的状态，判断是否在基因库中，判断是否满足end，即可满足条件
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        // 基因库：未来所有的可能性
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        int count = 1;
        if (!bankSet.contains(end)) {
            return -1;
        }
        if (start.equals(end)) {
            return count;
        }

        Deque<String> queue = new LinkedList<>();
        queue.addLast(start);
        bankSet.remove(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curString = queue.pollFirst();
                // 遍历下一状态的所有可能性
                for (int j = 0; j < curString.length(); j++) {
                    if (genNewGenetic(queue, bankSet, curString, j, 'A', end)
                        || genNewGenetic(queue, bankSet, curString, j, 'C', end)
                        || genNewGenetic(queue, bankSet, curString, j, 'G', end)
                        || genNewGenetic(queue, bankSet, curString, j, 'T', end)) {
                        return count;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private boolean genNewGenetic(Deque<String> queue, Set<String> bankSet, String curString, int j, char gen, String end) {
        String newGen = genGenetic(curString, j, gen);
        if (bankSet.remove(newGen)) {
            queue.addLast(newGen);
            if (newGen.equals(end)) {
                return true;
            }
        }
        return false;
    }

    private String genGenetic(String str, int j, char a) {
        char[] chars = str.toCharArray();
        chars[j] = a;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        new P433MinimumGeneticMutation().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
    }

    /**
     * 双向bfs解法
     */
    public int minMutation2(String start, String end, String[] bank) {
        Set<String> genBank = new HashSet<>(Arrays.asList(bank));
        if (!genBank.contains(end)) {
            return -1;
        }

        Set<String> startSet = new HashSet<>(), endSet = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.add(end);
        int len = start.length();
        int count = 1;
        char[] genItems = new char[] {'A', 'C', 'G', 'T'};

        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }

            Set<String> temp = new HashSet<>();
            for (String cur : startSet) {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < 4; j++) {
                        String nextGen = genNextGen(cur, i, genItems[j]);
                        if (genBank.contains(nextGen)) {
                            if (endSet.contains(nextGen)) {
                                return count;
                            }
                            if (visited.add(nextGen)) {
                                temp.add(nextGen);
                            }
                        }
                    }
                }
            }
            startSet = temp;
            count++;
        }

        return -1;
    }

    private String genNextGen(String cur, int index, char genItem) {
        char[] chars = cur.toCharArray();
        chars[index] = genItem;
        return String.valueOf(chars);
    }
}
