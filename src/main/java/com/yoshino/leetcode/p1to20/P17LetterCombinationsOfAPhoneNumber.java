package com.yoshino.leetcode.p1to20;

import java.util.*;

/**
 * 电话号码的字母组合
 **/
public class P17LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> numAphMap = new HashMap<>();
        char base = 'a';
        numAphMap.put('2', Arrays.asList(base++, base++, base++));
        numAphMap.put('3', Arrays.asList(base++, base++, base++));
        numAphMap.put('4', Arrays.asList(base++, base++, base++));
        numAphMap.put('5', Arrays.asList(base++, base++, base++));
        numAphMap.put('6', Arrays.asList(base++, base++, base++));
        numAphMap.put('7', Arrays.asList(base++, base++, base++, base++));
        numAphMap.put('8', Arrays.asList(base++, base++, base++));
        numAphMap.put('9', Arrays.asList(base++, base++, base++, base));
        List<String> ans = new ArrayList<>();
        if (digits.length() != 0) {
            dfs(digits, 0, "", ans, numAphMap);
        }
        return ans;
    }

    private void dfs(String digits, int index, String path, List<String> ans, Map<Character, List<Character>> numAphMap) {
        if (index == digits.length()) {
            ans.add(path);
            return;
        }
        for (Character ch : numAphMap.get(digits.charAt(index))) {
            dfs(digits, index + 1, path + ch, ans, numAphMap);
        }
    }
}
