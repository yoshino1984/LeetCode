package com.yoshino.leetcode.p201to220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课程表
 **/
public class P207CourseSchedule {

    /**
     * dfs解法，
     * 时间复杂度O(N)
     *
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] flag = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisity : prerequisites) {
            map.computeIfAbsent(prerequisity[0], key -> new ArrayList<>()).add(prerequisity[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, flag, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int[] flag, int key) {
        if (flag[key] == 2) {
            return true;
        } else if (flag[key] == 1) {
            return false;
        }
        flag[key] = 1;

        for (int prev : map.getOrDefault(key, new ArrayList<>())) {
            if (!dfs(map, flag, prev)) {
                return false;
            }
        }
        flag[key] = 2;

        return true;
    }
}
