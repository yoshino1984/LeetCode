package com.yoshino.p61to80;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 *
 * @author wangxin
 * 2020/6/7 23:04
 * @since
 **/
public class P77Combinations {

    /**
     * 回溯法
     */
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        this.k = k;
        this.n = n;
        myCombine(1, new ArrayList<>());
        return ans;
    }

    private void myCombine(int num, List<Integer> list) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 当剩余元素不够填充结果时，剪枝
        for (int i = num; i <= n + 1 - (k - list.size()); i++) {
            list.add(i);
            myCombine(i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    List<List<Integer>> ans;
    int n;
    int k;

    public static void main(String[] args) {
        new P77Combinations().combine(4, 2);
    }

}
