package com.yoshino.p251to300;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 丑数II
 *
 * @author wangxin
 * 2020/5/31 00:21
 * @since
 **/
public class P264UglyNumberii {

    public int nthUglyNumber(int n) {
        return (int) UGLY_NUMS[n - 1];
    }

    public static long[] UGLY_NUMS = new long[1690];

    static {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        Set<Long> seen = new HashSet<>();
        seen.add(1L);
        for (int i = 0; i < UGLY_NUMS.length; i++) {
            Long cur = heap.poll();
            UGLY_NUMS[i] = cur;
            addUglyNumber(heap, seen, cur * 2);
            addUglyNumber(heap, seen, cur * 3);
            addUglyNumber(heap, seen, cur * 5);
        }
    }

    private static void addUglyNumber(PriorityQueue<Long> heap, Set<Long> seen, Long uglyNum) {
        if (seen.add(uglyNum)) {
            heap.add(uglyNum);
        }
    }

}
