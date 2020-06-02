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

    private static final long[] UGLY_NUMS = new long[1690];

    static {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        pq.offer(1L);
        for (int i = 0; i < UGLY_NUMS.length; i++) {
            Long cur = pq.poll();
            UGLY_NUMS[i] = cur;
            addItem(pq, seen, cur * 2);
            addItem(pq, seen, cur * 3);
            addItem(pq, seen, cur * 5);
        }
    }

    private static void addItem(PriorityQueue<Long> pq, Set<Long> seen, Long uglyNum) {
        if (seen.add(uglyNum)) {
            pq.offer(uglyNum);
        }
    }
}
