package com.yoshino.leetcode.p201to220;

/**
 * 最短回文串
 **/
public class P214ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int left = 0, right = 0, mul = 1;
        int base = 131, mod = 1000000007;
        int best = -1;
        for (int i = 0; i < n; i++) {
            left = (int) (((long) left * base + s.charAt(i)) % mod);
            right = (int) ((right + (long) mul * s.charAt(i)) % mod);
            if (left == right) {
                best = i;
            }
            mul = (int) (((long) mul * base) % mod);
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuilder ans = new StringBuilder(add).reverse();
        ans.append(s);
        return ans.toString();
    }
}
