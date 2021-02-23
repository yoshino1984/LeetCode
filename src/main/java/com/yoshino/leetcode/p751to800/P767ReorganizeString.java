package com.yoshino.leetcode.p751to800;

import java.util.*;

/**
 * 重构字符串
 *
 * @author wangxin
 * 2020-02-09 10:09
 * @since
 **/
public class P767ReorganizeString {

    /**
     * Description:首选排序(按词频)，然后倒序进行组装重构
     * 时间复杂度：O(klogk) k指的是单词的数量
     * 空间复杂度O(N)
     *
     * @return :
     * @author : wangxin
     * @date : 2020-02-09 10:20
     */
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        char[] chars = S.toCharArray();
        sort(chars);
        char[] sortedChars = new char[chars.length + 1];
        int mid = chars.length / 2;
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                sortedChars[i] = chars[mid - i / 2 - (chars.length % 2 == 1 ? 0 : 1)];
            } else {
                sortedChars[i] = chars[chars.length - i / 2 - 1];
            }
        }
        String ans = "";
        if (mid % 2 == 0 && chars[mid] == chars[chars.length - 1]) {
            sortedChars[sortedChars.length - 1] = sortedChars[0];
            ans = new String(sortedChars, 1, sortedChars.length - 1);
        } else {
            ans = new String(sortedChars, 0, sortedChars.length - 1);
        }
        return isMatch(ans.toCharArray()) ?  ans : "";
    }

    private void sort(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        List<Map.Entry<Character, Integer>> infolds = new ArrayList<>(map.entrySet());
        infolds.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        int curIndex = 0;
        for (Map.Entry<Character, Integer> infold : infolds) {
            for (int i = 0; i < infold.getValue(); i++) {
                chars[i + curIndex] = infold.getKey();
            }
            curIndex += infold.getValue();
        }
    }

    private boolean isMatch(char[] sortedChars) {
        for (int i = 0; i < sortedChars.length - 1; i++) {
            if (sortedChars[i] == sortedChars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P767ReorganizeString obj = new P767ReorganizeString();
        System.out.println(obj.reorganizeString("aab"));
        System.out.println(obj.reorganizeString("aaab"));
        System.out.println(obj.reorganizeString("aaabb"));
        System.out.println(obj.reorganizeString("aabbccdd"));
        System.out.println(obj.reorganizeString("vvvlo"));
        System.out.println(obj.reorganizeString("blflxll"));
        System.out.println(obj.reorganizeString("abbabbaaab"));
    }
}
