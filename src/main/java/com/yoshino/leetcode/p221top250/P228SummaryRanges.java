package com.yoshino.leetcode.p221top250;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class P228SummaryRanges {

    /**
     * 一次遍历，记录区间的开始和结束
     * 注意0 1边界，和尾部的边界
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> resList = new ArrayList<>();
        if (len == 0) {
            return resList;
        }
        if (len == 1) {
            resList.add("" + nums[0]);
            return resList;
        }
        int front = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] - 1 > nums[i - 1]) {
                resList.add(genRange(nums, i, front));
                front = i;
            }
        }
        resList.add(genRange(nums, len, front));
        return resList;
    }

    private static String genRange(int[] nums, int len, int front) {
        if (front < len - 1) {
            return nums[front] + "->" + nums[len - 1];
        } else {
            return "" + nums[front];
        }
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(summaryRanges(new int[] {})));
        System.out.println(JSON.toJSONString(summaryRanges(new int[] {0})));
        System.out.println(JSON.toJSONString(summaryRanges(new int[] {0,1,2,4,5,7})));
        System.out.println(JSON.toJSONString(summaryRanges(new int[] {0,2,3,4,6,8,9})));
    }
}
