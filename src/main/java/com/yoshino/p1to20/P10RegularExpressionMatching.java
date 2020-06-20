package com.yoshino.p1to20;

public class P10RegularExpressionMatching {

    /**
     * 回溯法：时间复杂度最坏情况下很差
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch1(String s, String p) {
        isMatch = false;
        match(s, p, 0, 0);
        return isMatch;
    }

    private static boolean isMatch = false;
    private static boolean isBlank(String s) {
        return s == null || s.length() == 0;
    }

    private static void match(String s, String p, int sIndex, int pIndex) {
        if (isMatch) {
            return;
        }
        if (sIndex == s.length() && pIndex == p.length()) {
            isMatch = true;
            return;
        } else if (sIndex == s.length()) {
            if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
                match(s, p, sIndex, pIndex + 2);
            }
            return;
        } else if (pIndex == p.length()) {
            return;
        }

        if (p.charAt(pIndex) == '.' || s.charAt(sIndex) == p.charAt(pIndex)) {
            match(s, p, sIndex + 1, pIndex + 1);
            if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
                match(s, p, sIndex, pIndex + 1);
            }
        } else if (p.charAt(pIndex) == '*') {
            match(s, p, sIndex, pIndex + 1);// 处理零匹配的情况
            for (int i = sIndex; i < s.length(); i++) {
                if (p.charAt(pIndex - 1) == s.charAt(i) || p.charAt(pIndex - 1) == '.') {
                    match(s, p, i + 1, pIndex + 1);
                } else {
                    match(s, p, i, pIndex + 1);
                    break;
                }
            }
        } else if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            match(s, p, sIndex, pIndex + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch1("aa", "a"));
        System.out.println(isMatch1("aa", "a*"));
        System.out.println(isMatch1("ab", ".*"));
        System.out.println(isMatch1("aab", "c*a*b"));
        System.out.println(isMatch1("mississippi", "mis*is*p*."));
        System.out.println(isMatch1("aaa", "ab*a*c*a"));
        System.out.println(isMatch1("a", "ab*"));
        System.out.println(isMatch1("ab", ".*c"));
        System.out.println(isMatch1("bbbba", ".*a*a"));
        System.out.println(isMatch1("", ".*"));
        System.out.println(isMatch1("bbacbcabbbbbcacabb", "aa*c*b*a*.*a*a.*."));
    }

    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (match2(s, p, i, j - 1) && dp[i - 1][j]);
                } else {
                    if (match2(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    private boolean match2(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        return p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1);
    }
}
