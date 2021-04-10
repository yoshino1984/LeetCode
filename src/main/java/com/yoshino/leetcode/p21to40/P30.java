package com.yoshino.leetcode.p21to40;

import java.util.*;

/**
 * @author wangxin
 * 2021/4/10 18:28
 * @since
 **/
public class P30 {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        int wordSize = words.length;
        int wordLen = words[0].length();
        int allLen = wordSize * wordLen;
        Map<String, Integer> wordCounter = new HashMap<>();
        for (String word : words) {
            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0, limit = s.length() - allLen; i <= limit; i++) {
            String temp = s.substring(i, i + allLen);
            Map<String, Integer> tempMap = new HashMap<>();
            for (int j = 0; j < wordSize; j++) {
                String tempWord = temp.substring(j * wordLen, j * wordLen + wordLen);
                tempMap.put(tempWord, tempMap.getOrDefault(tempWord, 0) + 1);
                if (tempMap.get(tempWord) > wordCounter.getOrDefault(tempWord, 0)) {
                    break;
                }
            }
            if (tempMap.equals(wordCounter)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));;
    }
}
