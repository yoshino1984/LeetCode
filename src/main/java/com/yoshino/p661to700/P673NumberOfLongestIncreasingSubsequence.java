package com.yoshino.p661to700;

import java.util.*;

public class P673NumberOfLongestIncreasingSubsequence {


    /**
     * 动态规划：需要维护每个下标对应的最长子序列长度length和最长子序列数量count
     * 时间复杂度O(NlogN)
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {

        int[] counts = new int[nums.length];
        int[] lengths = new int[nums.length];
        Arrays.fill(counts, 1);
        Arrays.fill(lengths, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (lengths[j] >= lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] == lengths[i] - 1) {
                        counts[i] += counts[j];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }





    public static int findNumberOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> valCnt = new HashMap<>();
        // 初始化
        List<List<Integer>> equalLengthIndexs = new ArrayList<>();
        List<Integer> equalLengthVal = new ArrayList<>();
        equalLengthVal.add(0);
        // 特殊处理第一个数字
        equalLengthIndexs.add(equalLengthVal);
        valCnt.put(0, 1);
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            int curVal = nums[i];
            Integer count = 0;
            for (int j = maxLength - 1; j >= 0; j--) {
                for (Integer index : equalLengthIndexs.get(j)) {
                    // 对比当前元素和当前层级元素的大小
                    if (curVal > nums[index]) {
                        count += valCnt.get(index);
                    }
                }
                if (count > 0) {
                    int curLenth = j + 2;
                    if (curLenth > maxLength) {
                        // 扩容
                        List<Integer> currList = new ArrayList<>();
                        currList.add(i);
                        equalLengthIndexs.add(currList);
                        maxLength = curLenth;
                    } else {
                        equalLengthIndexs.get(j + 1).add(i);
                    }
                    valCnt.put(i, count);
                    break;
                }
            }
            if (count == 0) {
                equalLengthIndexs.get(0).add(i);
                valCnt.put(i, 1);
            }
        }

        int maxCount = 0;
        for (Integer index : equalLengthIndexs.get(maxLength - 1)) {
            maxCount += valCnt.get(index);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5}));
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(findNumberOfLIS(new int[]{1,2,3,1,2,3,1,2,3}));
    }
}
