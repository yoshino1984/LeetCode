package com.yoshino.leetcode.p601to650;

import java.util.Arrays;

/**
 * 任务调度器
 **/
public class P621TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0) {
                    break;
                }
                if (i < 26 && map[25 - i] > 0) {
                    map[25 - i]--;
                }
                i++;
                time++;
            }
            Arrays.sort(map);
        }
        return time;
    }

    /**
     * 设计法，任务安排中，所有的
     *
     * @param tasks
     * @param n
     * @return int
     * author: wangxin
     * date: 2020/5/3 12:29
     */
    public static int leastInterval2(char[] tasks, int n) {
        int[] counter = new int[26];
        for (char task : tasks) {
            counter[task - 'A']++;
        }
        Arrays.sort(counter);
        int maxExecTime = counter[25];
        int maxCount = (int) Arrays.stream(counter).filter(count -> count == maxExecTime).count();

        return Math.max(tasks.length, (maxExecTime - 1) * (n + 1) + maxCount);
    }

    public static void main(String[] args) {
//        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 50));
        System.out.println(leastInterval2(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 50));

    }
}
