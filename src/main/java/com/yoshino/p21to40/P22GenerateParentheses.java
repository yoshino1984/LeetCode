package com.yoshino.p21to40;

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
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generate(0, 0, n, "");
        return ans;
    }

    private void generate(int left, int right, int n, String str) {
        if (left == n && right == n) {
            ans.add(str);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, str + "(");
        }
        if (right < left) {
            generate(left, right + 1, n, str + ")");
        }
    }
}
