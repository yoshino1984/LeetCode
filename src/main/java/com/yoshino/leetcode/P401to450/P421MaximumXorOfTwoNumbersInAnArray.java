package com.yoshino.leetcode.P401to450;

import java.util.Arrays;

/**
 * 数组中两个数的最大异或值
 **/
public class P421MaximumXorOfTwoNumbersInAnArray {

    /**
     * 首先将nums统一处理成最长的位字符串
     * 将位字符串插入trieTree中，加速比较过程
     * 对于一个num 从高位开始判断，是否有异或结果为1的，如果有则走该分支，没有则走另外一条分支
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    TrieNode root;
    public int findMaximumXOR(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int maxLen = Integer.toBinaryString(maxNum).length();
        root = new TrieNode();
        String[] numBits = genNumBits(nums, maxLen);
        for (String num : numBits) {
            insert(num);
        }

        int ans = 0;
        for (String num : numBits) {
            int res = findMaxXOR(num);
            ans = Math.max(res, ans);
        }

        return ans;
    }

    private String[] genNumBits(int[] nums, int maxLen) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            String num = Integer.toBinaryString(nums[i]);
            StringBuilder prefixBit = new StringBuilder();
            for (int j = num.length(); j < maxLen; j++) {
                prefixBit.append('0');
            }
            numStrs[i] = prefixBit.toString() + num;
        }
        return numStrs;
    }

    private int findMaxXOR(String num) {
        StringBuilder ans = new StringBuilder();
        TrieNode node = root;
        char[] chars = num.toCharArray();
        for (char ch : chars) {
            char newCh = ch == '0' ? '1' : '0';
            if (node.containKey(newCh)) {
                node = node.get(newCh);
                ans.append('1');
            } else {
                node = node.get(ch);
                ans.append('0');
            }
        }

        return Integer.parseUnsignedInt(ans.toString(), 2);
    }

    private void insert(String num) {
        TrieNode node = root;
        char[] chars = num.toCharArray();
        for (char ch : chars) {
            if (!node.containKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
    }

    class TrieNode {
        TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[2];
        }

        public boolean containKey(char index) {
            return child[index - '0'] != null;
        }

        public TrieNode get(char ch) {
            return child[ch - '0'];
        }

        public void put(char ch, TrieNode node) {
            child[ch - '0'] = node;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        int ans = new P421MaximumXorOfTwoNumbersInAnArray().findMaximumXOR(nums);
        System.out.println(ans);
    }
}
