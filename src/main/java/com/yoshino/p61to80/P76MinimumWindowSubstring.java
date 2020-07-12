package com.yoshino.p61to80;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 最小覆盖子串
 **/
public class P76MinimumWindowSubstring {

    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
       int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();

        while (right++ < sLen) {
            if (right < sLen && ori.containsKey(s.charAt(right))) {
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);
            }

            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (ori.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        AtomicBoolean ans = new AtomicBoolean(true);
        ori.forEach((key, value) -> {
            if (cnt.getOrDefault(key, 0) < value) {
                ans.set(false);
            }
        });
        return ans.get();
    }


}
