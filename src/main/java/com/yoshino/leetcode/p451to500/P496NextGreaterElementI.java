package com.yoshino.leetcode.p451to500;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大的元素（时间复杂度 O(M+N)）
 * 2020/5/2 21:42
 * @since
 **/
public class P496NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>((int)(nums2.length / 0.75) + 1);
        int[] res = new int[nums1.length];
        for (int value : nums2) {
            while (!stack.isEmpty() && stack.peek() < value) {
                map.put(stack.pop(), value);
            }
            stack.push(value);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }
}
