package com.yoshino.leetcode.p651to700;

import java.util.ArrayList;
import java.util.List;

/**
 * 24点游戏
 *
 * @author wangxin
 * 2020/8/22 23:06
 * @since
 **/
public class P679_24Game {
    private static int TARGET = 24;
    private static double EPSILON = 1e-6;
    private static int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVISION = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                List<Double> list2 = new ArrayList<>();
                if (list.size() > 2) {
                    for (int k = 0; k < size; k++) {
                        if (i != k && j != k) {
                            list2.add(list.get(k));
                        }
                    }
                }
                for (int k = 0; k < 4; k++) {
                    if (k < 2 && i > j) {
                        continue;
                    }
                    if (k == ADD) {
                        list2.add(list.get(i) + list.get(j));
                    } else if (k == MULTIPLY) {
                        list2.add(list.get(i) * list.get(j));
                    } else if (k == SUBTRACT) {
                        list2.add(list.get(i) - list.get(j));
                    } else if (k == DIVISION) {
                        if (list.get(j) < EPSILON) {
                            continue;
                        } else {
                            list2.add(list.get(i) / list.get(j));
                        }
                    }
                    if (solve(list2)) {
                        return true;
                    }
                    list2.remove(list2.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new P679_24Game().judgePoint24(new int[]{1,2,1,2});
    }
}
