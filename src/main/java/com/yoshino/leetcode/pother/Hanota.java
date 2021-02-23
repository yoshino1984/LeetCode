package com.yoshino.leetcode.pother;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 汉诺塔问题
 * 时间复杂度O(2^n)
 **/
public class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    private void move(int n, List<Integer> from, List<Integer> temp, List<Integer> dest) {
        if (n == 1) {
            dest.add(from.remove(from.size() - 1));
            return;
        }
        move(n - 1, from, dest, temp);
        move(1, from, temp, dest);
        move(n - 1, temp, from, dest);
    }

    public static void main(String[] args) {
        List<Integer> A = Lists.newArrayList(2, 1, 0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        new Hanota().hanota(A, B, C);
        System.out.println(JSON.toJSONString(C));
    }

}
