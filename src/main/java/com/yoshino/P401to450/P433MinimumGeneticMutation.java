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
}
