package com.yoshino.p81to100;

import java.util.Stack;

public class P84LargestRectangleInHistogram {

    /**
     * 栈
     * 使用栈来记录历史柱状图的高度 （原理是计算以某根柱子a作为最低高度，寻找a的左右边界的过程
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (length - stack.peek() - 1));
        }
        return maxArea;
    }

    /**
     * 动态规划解法：求解（i, j）之间的最小高度，然后求解面积
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        int height = heights.length;
        int minHeight = 0;
        int maxArea = 0;
        for (int i = 0; i < height; i++) {
            minHeight = heights[i];
            for (int j = i; j < height; j++) {
                minHeight = Math.min(heights[j], minHeight);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        System.out.println(largestRectangleArea(new int[]{1}));
//        System.out.println(largestRectangleArea(new int[]{}));
//        System.out.println(largestRectangleArea(new int[]{1, 2}));
//        System.out.println(largestRectangleArea(new int[]{1, 2, 3}));
//        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{5, 4, 1, 2}));
    }
}
