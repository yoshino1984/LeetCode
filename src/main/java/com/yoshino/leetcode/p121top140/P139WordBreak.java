package com.yoshino.leetcode.p121top140;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 **/
public class P139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }


}
