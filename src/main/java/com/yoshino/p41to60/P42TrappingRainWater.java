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

}
