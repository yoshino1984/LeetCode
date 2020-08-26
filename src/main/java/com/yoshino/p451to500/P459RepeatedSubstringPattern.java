package com.yoshino.p451to500;

/**
 * 重复的子字符串
 **/
public class P459RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i * 2 <= len; i++) {
            if (len % i != 0) {
                continue;
            }
            boolean isMatch = true;
            for (int j = i; j < len; j++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return true;
            }
        }
        return false;
    }

}
