package com.yoshino.leetcode.p351to400;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  至少有 K 个重复字符的最长子串
 *
 * @since
 **/
public class P395 {

    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, AtomicInteger> counterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counterMap.computeIfAbsent(s.charAt(i), key -> new AtomicInteger()).incrementAndGet();
        }
        for (Character ch : counterMap.keySet()) {
            if (counterMap.get(ch).get() < k) {
                int res = 0;
                for (String str : s.split(String.valueOf(ch))) {
                    res = Math.max(res, longestSubstring(str, k));
                }
                return res;
            }
        }

        return s.length();

    }
}
