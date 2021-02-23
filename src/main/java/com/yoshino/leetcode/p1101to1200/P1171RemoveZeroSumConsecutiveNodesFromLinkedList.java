package com.yoshino.leetcode.p1101to1200;

import com.yoshino.leetcode.model.ListNode;

import java.util.HashMap;
import java.util.Map;

public class P1171RemoveZeroSumConsecutiveNodesFromLinkedList {

    /**
     * 计算所有节点的累加值，如果两个节点的值相等，则代表，这两个节点之间的总和为0
     * 时间复杂度O(N)
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> sumIndex = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        // 第一次遍历记录所有节点的累加总和
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            sumIndex.put(sum, d);
        }
        // 第二次遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = sumIndex.get(sum).next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(158+328+128);
    }
}
