package com.yoshino.p61to80;

import java.util.Arrays;

public class P72EditDistance {

    public static int minDistance(String word1, String word2) {
        int s1Length = word1.length();
        int s2Length = word2.length();
        int[][] dp = new int[s1Length + 1][s2Length + 1];
        // init boundaries
        for (int i = 0; i < s1Length + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < s2Length + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1] - 1);
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[s1Length][s2Length];

    }

//    public static int minDistance(String word1, String word2) {
//        // fixme 思路不对，不应该计算相同的，而是直接计算不同的部分，即编辑距离
////        // 首先获取最长的相同顺序子串
////        int s1Length = word1.length();
////        int s2Length = word2.length();
////        int[][] dp = new int[s1Length + 1][s2Length + 1];
////        for (int i = 1; i <= s1Length; i++) {
////            for (int j = 1; j <= s2Length; j++) {
////                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
////                    dp[i][j] = dp[i - 1][j - 1] + 1;
////                } else {
////                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
////                }
////            }
////        }
////
////        if (dp[s1Length][s2Length] == 0) {
////
////            return s2Length + Math.max(s1Length - s2Length, 0);
////        }
////        // 提取出相同顺序子串
////        int tempi = s1Length;
////        int tempj = s2Length;
////        int[][] indexs = new int[2][dp[tempi][tempj]];
////        for (int count = dp[tempi][tempj] - 1; count >= 0;) {
////            if (dp[tempi][tempj] > dp[tempi - 1][tempj] && dp[tempi][tempj] > dp[tempi][tempj - 1]) {
////                indexs[0][count] = tempi;
////                indexs[1][count] = tempj;
////                tempi--;
////                tempj--;
////                count--;
////            } else if (dp[tempi][tempj] == dp[tempi - 1][tempj]) {
////                tempi--;
////            } else {
////                tempj--;
////            }
////        }
////
////        int cnt = 0;
////        for (int i = 0; i < dp[s1Length][s2Length]; i++) {
////            if (i == 0) {
////                cnt = Math.abs(indexs[0][i] - indexs[1][i]) + indexs[1][i] - 1;
////            } else {
////                cnt += Math.max((indexs[0][i] - indexs[0][i - 1]) - (indexs[1][i] - indexs[1][i - 1]), 0)
////                    + indexs[1][i] - indexs[1][i - 1] - 1;
////            }
////
////        }
////        return cnt;
//    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("h", "r"));
        System.out.println(minDistance("h", ""));
        System.out.println(minDistance("", ""));
        System.out.println(minDistance("", "r"));
        System.out.println(minDistance("rea", "ra"));
        System.out.println(minDistance("ra", "rea"));
        System.out.println(minDistance("intention", "execution"));
    }

}
