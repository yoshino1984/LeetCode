package com.yoshino.leetcode.p201to220;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 同构字符串
 **/
public class P205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sCharMap = new HashMap<>();
        Set<Character> visited = new HashSet<>();

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            Character tCh = tArr[i];
            if (sCharMap.containsKey(sArr[i])) {
                if (!sCharMap.get(sArr[i]).equals(tCh)) {
                    return false;
                }
            } else {
                if (!visited.add(tCh)) {
                    return false;
                }
                sCharMap.put(sArr[i], tCh);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new P205IsomorphicStrings().isIsomorphic("ego", "add");
    }
}
