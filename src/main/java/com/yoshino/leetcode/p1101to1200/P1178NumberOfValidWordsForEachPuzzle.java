package com.yoshino.leetcode.p1101to1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @since
 **/
public class P1178NumberOfValidWordsForEachPuzzle {


    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, AtomicInteger> bitCountMap = new HashMap();
        for (String word : words) {
            Integer key = genKey(word);
            if (Integer.bitCount(key) <= 7) {
                bitCountMap.computeIfAbsent(key, k -> new AtomicInteger()).incrementAndGet();
            }
        }

        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int firstBit = 1 << (puzzle.charAt(0) - 'a');
            int mask = genKey(puzzle) ^ firstBit;
            int subset = mask;
            int total = 0;
            do {
                int s = subset | firstBit;
                if (bitCountMap.containsKey(s)) {
                    total += bitCountMap.get(s).get();
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            result.add(total);
        }

        return result;
    }

    public Integer genKey(String word) {
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            mask |= (1 << (word.charAt(i) - 'a'));
        }
        return mask;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(new P1178NumberOfValidWordsForEachPuzzle().findNumOfValidWords(words, puzzles));;
    }
}
