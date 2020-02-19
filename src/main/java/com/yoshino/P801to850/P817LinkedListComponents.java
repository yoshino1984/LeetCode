package com.yoshino.P801to850;

import com.yoshino.model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P817LinkedListComponents {

    /**
     * 使用set集合来为head中元素判定提供一个O(1)的方式，一次遍历
     * 时间复杂度O(N)
     * 空间复杂度O(k) k为列表的大小
     * @param head
     * @param G
     * @return
     */
    public int numComponents(ListNode head, int[] G) {
        if (head == null || G.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int i : G) {
            numSet.add(i);
        }
        int count = 0;
        int curCnt = 0;
        while (head != null) {
            int val = head.val;
            head = head.next;
            if (numSet.contains(val)) {
                curCnt++;
                continue;
            } else if (curCnt > 0){
                count++;
            }
            curCnt = 0;
        }
        if (curCnt > 0) {
            count++;
        }
        return count;
    }

}
