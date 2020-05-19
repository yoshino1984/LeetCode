package com.yoshino.p1to20;

/**
 * @author wangxin
 * 2020/5/19 22:47
 * @since
 **/
public class P11ContainerWithMostWater {

    /**
     * 暴力循环 O(N^2)
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[j], height[i]);
                max = Math.max(max, area);
            }
        }
        return max;
    }


    public int maxArea2(int[] height) {
        int max = 0;
        int low = 0, high = height.length - 1;
        while (low < high) {
            int area = (high - low) * (height[low] > height[high] ? height[high--] : height[low++]);
            max = Math.max(area, max);
        }
        return max;
    }

    public int maxArea3(int[] height) {
        int max = 0;
        int low = 0, high = height.length - 1;
        int maxHeight = 0;
        while (low < high) {
            int curWidth = high - low;
            int curHeight = (height[low] > height[high] ? height[high--] : height[low++]);
            if (curHeight <= maxHeight) {
                continue;
            }
            maxHeight = curHeight;
            int area = curWidth * curHeight;
            max = Math.max(area, max);
        }
        return max;
    }


}
