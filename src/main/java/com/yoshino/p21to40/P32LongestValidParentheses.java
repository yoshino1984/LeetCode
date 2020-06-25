package com.yoshino.p21to40;

public class P32LongestValidParentheses {


    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
     * 使用动态规划解，状态转移表达式需要处理，(')' 和(()')'这两种情况，以及最开始的边界值（防止越界）
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public static int longestValidParentheses2(String s) {
        int left = 0, right = 0, max =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (left < right) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(longestValidParentheses(""));
//        System.out.println(longestValidParentheses("("));
//        System.out.println(longestValidParentheses("(()())")); // 3
//        System.out.println(longestValidParentheses(")()(")); // 1
//        System.out.println(longestValidParentheses(")()())")); // 2
    }
}
