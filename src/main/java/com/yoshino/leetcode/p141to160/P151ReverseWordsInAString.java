package com.yoshino.leetcode.p141to160;

import com.alibaba.fastjson.JSON;

public class P151ReverseWordsInAString {

    /**
     * 不使用Java split的情况下可以这么转换
     * 时间复杂度O(N) 使用split的情况下，拆分成数组，然后倒序遍历拼装即可
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        reverseString(chars, 0, chars.length - 1);
        int low = 0;
        int high = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseString(chars, low, high);
                low = i + 1;
                high = i;
            } else {
                high++;
            }
        }
        if (chars[chars.length - 1] != ' ') {
            reverseString(chars, low, high);
        }
        int blankCount = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ' ' && chars[i - 1] == ' ') {
                blankCount++ ;
            } else {
                chars[i - blankCount] = chars[i];
            }
        }
        return String.valueOf(chars).substring(0, chars.length - blankCount);
    }


    public static void reverseString(char[] chars, int s, int e) {
        int size = (e + s) / 2;
        char temp;
        for (int i = s; i <= size; i++) {
            temp = chars[e - i + s];
            chars[e - i + s] = chars[i];
            chars[i] = temp;
        }
    }

    public static void main(String[] args) {

//        char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
//        reverseString(s, 0, 4);
//        System.out.println(JSON.toJSONString(s));

        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));

        System.out.println(JSON.toJSONString("  s fs   dsf".split(" ")));
    }

}
