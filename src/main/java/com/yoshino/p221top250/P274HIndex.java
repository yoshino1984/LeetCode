package com.yoshino.p221top250;

import java.util.Arrays;
import java.util.Comparator;

public class P274HIndex {

    /**
     * 首先排序，然后降序计数即可
     * 时间复杂度O(NlogN)
     * 空间复杂度O(1)
     *
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        if (citations[citations.length - 1] == 0) {
            return 0;
        }
        int i = 0;
        for (; i < citations.length; i++) {
            if (i > citations[citations.length - 1 - i]) {
                break;
            }
        }
        return Math.min(i, citations[citations.length - i]);
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[] {3, 0, 6, 1, 5}));
        System.out.println(hIndex(new int[] {0}));
        System.out.println(hIndex(new int[] {1,1}));
    }

}
