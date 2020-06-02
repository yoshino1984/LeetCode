package com.yoshino.p41to60;

import java.util.Stack;

/**
 * 接雨水
 *
 * 2020/4/5 00:01
 * @since
 **/
public class P42TrappingRainWater {

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public static int trap(int[] height) {
        int ans = 0;
        int cur = 0;
        Stack<Integer> st = new Stack<>();
        while (cur < height.length) {
            while (!st.isEmpty() && height[cur] > height[st.peek()]) {
                int top = st.pop();
                if (st.isEmpty()) {
                    break;
                }
                int distance = cur - st.peek() - 1;
                int boundHeight = Math.min(height[cur], height[st.peek()]) - height[top];
                ans += distance * boundHeight;
            }
            st.push(cur++);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    /**
     * 双指针解法
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    public static int trap1(int[] height) {
        int ans = 0;
        int left = 1, right = height.length - 2;
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            if (height[left - 1] < height[right + 1]) {
                leftMax = Math.max(height[left - 1], leftMax);
                ans += Math.max(0, leftMax - height[left]);
                left++;
            } else {
                rightMax = Math.max(height[right + 1], rightMax);
                ans += Math.max(0, rightMax - height[right]);
                right--;
            }
        }
        return ans;
    }

    public static int trap2(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int curIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[curIndex];
                if (boundedHeight > 0) {
                    ans += width * boundedHeight;
                }

            }
            stack.push(i);
        }
        return ans;
    }
}
