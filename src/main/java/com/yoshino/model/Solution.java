package com.yoshino.model;

import java.util.*;

/**
 * 刻意练习地方
 **/
class Solution {

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