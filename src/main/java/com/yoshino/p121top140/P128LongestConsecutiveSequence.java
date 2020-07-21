package com.yoshino.p121top140;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 最长连续序列
 **/
public class P128LongestConsecutiveSequence {

    /**
     * 默认从连续序列的最小元素开始遍历整个序列（使用map加速读取）
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            if (numSet.contains(num - 1)) {
                continue;
            }

            int base = num;
            int count = 0;
            while (numSet.contains(base)) {
                base++;
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    /**
     * 并查集解法
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> valIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valIndex.put(nums[i], i);
        }
        UnionFind unionFind = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (valIndex.containsKey(nums[i] + 1)) {
                unionFind.union(i, valIndex.get(nums[i] + 1));
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[unionFind.find(i)] - nums[i] + 1);
        }

        return max;
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int val) {
            while (val != parent[val]) {
                parent[val] = parent[parent[val]];
                val = parent[val];
            }
            return val;
        }

        public void union(int v1, int v2) {
            int rootV1 = find(v1);
            int rootV2 = find(v2);
            if (rootV1 != rootV2) {
                parent[rootV1] = rootV2;
            }
        }
    }
}
