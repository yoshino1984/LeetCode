package com.yoshino.p41to60;

/**
 * 最后一个单词的长度
 **/
public class P58LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(s.length() - i - 1)) {
                if (count != 0) {
                    return count;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
