package com.yoshino.p101to120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P120Triangle {


    /**
     * 动态规划的方法
     * 使用数组比使用动态数组更省时间和空间（区别应该不大）
     * 时间复杂度O(N) ， N为三角形所有元素的个数
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        // 初始化第一个元素
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[] minPathSum = new int[triangle.size()];
        minPathSum[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curNum = triangle.get(i);
            minPathSum[curNum.size() - 1] = minPathSum[curNum.size() - 2] + curNum.get(curNum.size() - 1);
            for (int j = curNum.size() - 2; j > 0; j--) {
                minPathSum[j] = curNum.get(j) + Math.min(minPathSum[j], minPathSum[j - 1]);
            }
            minPathSum[0] = minPathSum[0] + curNum.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (Integer integer : minPathSum) {
            min = Math.min(min, integer);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        System.out.println(minimumTotal(triangle));
    }
}
