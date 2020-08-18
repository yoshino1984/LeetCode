package com.yoshino.model;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 刻意练习地方
 **/
class Solution {


    public List<Integer> findAnagrams(String s, String p) {
        int pHash = 0, pLen = p.length();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] counter = new int[26];
        for (char ch : pArr) {
            int val = ch - 'a';
            pHash += val * val;
            counter[val]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int curVal = sArr[i] - 'a';
            pHash -= curVal * curVal;
            counter[curVal]--;
            if (i < pLen - 1) {
                continue;
            }

            int start = i - pLen + 1;
            if (0 == pHash && isMatch(counter)) {
                ans.add(start);
            }
            int startVal = sArr[start] - 'a';
            pHash += startVal * startVal;
            counter[startVal]++;
        }

        return ans;
    }

    private boolean isMatch(int[] counter) {
        return Arrays.stream(counter).allMatch(i -> i == 0);
    }

    public static void main(String[] args) {
        new Solution().findAnagrams("cbaebabacd", "abc");
    }
}
