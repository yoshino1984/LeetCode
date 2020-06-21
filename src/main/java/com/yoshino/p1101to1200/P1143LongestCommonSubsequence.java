package com.yoshino.p1101to1200;

public class P1143LongestCommonSubsequence {


    /**
     * for循环 动态规划
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 利用边界值默认为0的特性，减少处理次数
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j)
                    ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[len1][len2];
    }

    /**
     * 动态规划(递归形态自顶向下，改成for循环自底向上速度会快很多：40ms-》8ms)
     * 时间复杂度O(NM) N和M分别为两个字符串的长度
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.memo = new int[text1.length()][text2.length()];
        return dp(text1.length() - 1, text2.length() - 1);
    }
    private int[][] memo;
    private String text1;
    private String text2;

    private int dp( int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = dp(i - 1, j - 1) + 1;
        } else {
            memo[i][j] = Math.max(dp(i - 1, j), dp(i, j - 1));
        }

        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new P1143LongestCommonSubsequence().longestCommonSubsequence1("abcde", "ace"));
    }

}
