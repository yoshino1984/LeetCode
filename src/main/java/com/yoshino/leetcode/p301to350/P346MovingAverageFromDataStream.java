package com.yoshino.leetcode.p301to350;

/**
 * 数据流中的移动平均值
 * 时间复杂度O(N) 注意循环队列的边界值和赋值
 *
 * @author wangxin
 * 2020/5/3 10:58
 * @since
 **/
public class P346MovingAverageFromDataStream {
}

class MovingAverage {

    private final int[] items;
    private int head;
    private double sum;
    private int count;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        items = new int[size];
        head = 0;
        this.count = 0;
    }

    public double next(int val) {
        count = Math.min(count + 1, items.length);
        int removeItem = items[head];
        items[head] = val;
        head = (head + 1) % items.length;
        sum = sum + val - removeItem;
        return sum / count;
    }
}
