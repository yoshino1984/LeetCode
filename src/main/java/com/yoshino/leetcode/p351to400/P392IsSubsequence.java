package com.yoshino.leetcode.p351to400;

/**
 * 判断子序列
 **/
public class P392IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int si = 0, ti = 0;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        for (; ti < t.length(); ti++) {
            if (schars[si] == tchars[ti]) {
                si++;
            }
            if (si == s.length()) {
                return true;
            }
        }

        return false;
    }

}
