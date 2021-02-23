package com.yoshino.leetcode.p21to40;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解法
 **/
public class P22GenerateParentheses {

    /**
     * 递归解法
     * 时间复杂度
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0, n, "", ans);
        return ans;
    }

    private void generate(int left, int right, int max, String str, List<String> ans) {
        if (left == max && right == max) {
            ans.add(str);
            return;
        }

        if (left < max) {
            generate(left + 1, right, max, str + "(", ans);
        }
        if (right < left) {
            generate(left, right + 1, max, str + ")", ans);
        }
    }
}
