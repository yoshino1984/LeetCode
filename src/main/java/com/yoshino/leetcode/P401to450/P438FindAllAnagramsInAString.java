package com.yoshino.leetcode.P401to450;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 **/
public class P438FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int len = p.length();
        int sHash = 0;
        int pHash = 0;
        for (char ch : pArr) {
            pHash += ch;
        }
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            sHash += sArr[i];
            if (i < len - 1) {
                continue;
            }
            if (sHash == pHash && isAnagrams(sArr, pArr, i - len + 1, len)) {
                ans.add(i - len + 1);
            }
            sHash -= sArr[i - len + 1];
        }

        return ans;
    }

    private boolean isAnagrams(char[] sArr, char[] pArr, int start, int len) {
        int[] counter = new int[26];
        for (int i = 0; i < len; i++) {
            counter[sArr[i + start] - 'a']++;
            counter[pArr[i] - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
