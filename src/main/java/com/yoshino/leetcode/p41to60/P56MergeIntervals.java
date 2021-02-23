package com.yoshino.leetcode.p41to60;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class P56MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        List<int[]> sortIntervals = new ArrayList<>(Arrays.asList(intervals));
        sortIntervals.sort(Comparator.comparing(s -> s[0]));
        List<int[]> resList = new ArrayList<>();
        int[] lastEndVal = sortIntervals.get(0);
        for (int[] interval : sortIntervals) {
            if (interval[0] <= lastEndVal[1]) {
                lastEndVal[1] = Math.max(interval[1], lastEndVal[1]);
            } else {
                resList.add(lastEndVal);
                lastEndVal = interval;
            }
        }
        resList.add(lastEndVal);
        int[][] resArr = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1,3}, {2,6}, {8, 10}, {5, 7}};
//        int[][] intervals = new int[][]{{1,4}, {4,5}};
        int[][] intervals = new int[][]{{1,4}, {2,3}};
        System.out.println(JSON.toJSONString(intervals));
        System.out.println(JSON.toJSONString(merge(intervals)));
    }
}
