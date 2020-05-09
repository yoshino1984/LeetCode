package com.yoshino.p951to1000;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最接近原点的k个点 k-closest-points-to-origin
 * 时间复杂度O(nlogn)
 *
 * @author wangxin
 * 2020/5/9 10:52
 * @since
 **/
public class P973KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        if (points.length <= K || K == 0) {
            return points;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int value1 = o1[0] * o1[0] + o1[1] * o1[1];
                int value2 = o2[0] * o2[0] + o2[1] * o2[1];
                return Integer.compare(value1, value2);
            }
        });
        queue.addAll(Arrays.asList(points));
        int[][] ret = new int[K][2];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }

    public int[][] kClosest1(int[][] points, int K) {
        if (points.length <= K || K == 0) {
            return points;
        }
        PointHeap pointHeap = new PointHeap(K);


        for (int i = 0; i < points.length; i++) {
            pointHeap.insert(points[i]);
        }
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point point = pointHeap.items[i];
            ret[i][0] = point.getX();
            ret[i][1] = point.getY();
        }
        return ret;
    }

    private class PointHeap {
        private Point[] items;
        private int n;
        private int count;

        public PointHeap(int capacity) {
            this.items = new Point[capacity];
            this.n = capacity;
            this.count = 0;
        }

        public void insert(int[] pointXy) {
            Point point = new Point(pointXy[0], pointXy[1]);
            if (count >= n) {
                // 处理删除逻辑
                if (point.getValue() < items[0].getValue()) {
                    items[0] = point;
                    heapify(items, items.length - 1, 0);
                }
                return;
            }
            insertUnFill(point);
        }

        private void insertUnFill(Point point) {
            int i = count;
            items[count] = point;
            count++;
            while (i > 0) {
                if (items[(i - 1) / 2].getValue() < items[i].getValue()) {
                    swap(items, (i - 1) / 2, i);
                } else {
                    break;
                }
                i = (i - 1) / 2;
            }

        }

        private void heapify(Point[] items, int maxIndex, int i) {
            while(true) {
                int maxPos = i;
                if ((i * 2 + 1) <= maxIndex && items[i * 2 + 1].getValue() > items[i].getValue()) {
                    maxPos = i * 2 + 1;
                }
                if ((i * 2 + 2) <= maxIndex && items[i * 2 + 2].getValue() > items[maxPos].getValue()) {
                    maxPos = i * 2 + 2;
                }
                if (maxPos == i) {
                    break;
                }
                swap(items, maxPos, i);
                i = maxPos;
            }
        }

        private void swap(Point[] items, int i, int j) {
            Point temp = items[i];
            items[i] = items[j];
            items[j] = temp;
        }
    }

    private class Point {
        private int x;
        private int y;
        private int value;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.value = x * x + y * y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        P973KClosestPointsToOrigin svc = new P973KClosestPointsToOrigin();
        int[][] points = new int[][] {{3,3},{5,-1},{-2,4}};
        int[][] ret = svc.kClosest(points, 2);
        System.out.println(JSON.toJSON(ret));
    }
}
