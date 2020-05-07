package com.yoshino.p701to750;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 每日温度
 *
 * @author wangxin
 * 2020/5/7 20:28
 * @since
 **/
public class P739DailyTemperatures {

    /**
     * 使用栈来存储数组映射
     * 时间复杂度O(N)，空间复杂度O(N)
     *
     * @param T
     * @return
     */
    public int[] dailyTemperaturesStack(int[] T) {
        if (T == null) {
            return T;
        }
        int[] ret = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                ret[index] = i - index;
            }
            stack.push(i);
        }
        return ret;
    }

    /**
     * 哈希算法的方式求解（因为）
     * @param T
     * @return
     */
    public int[] dailyTemperaturesHash(int[] T) {
        if (T == null) {
            return T;
        }
        int[] ret = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                ret[index] = i - index;
            }
            stack.push(i);
        }
        return ret;
    }
}
