package com.yoshino.leetcode.p1to20;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangxin
 * 2021/3/18 11:14
 * @since
 **/
public class P3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0, n = s.length();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j + 1);
            result = Math.max(result, j - i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        new P3().lengthOfLongestSubstring("abcabcbb");
    }
}


