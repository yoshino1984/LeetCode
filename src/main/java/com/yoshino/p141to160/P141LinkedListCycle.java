package com.yoshino.p141to160;

import com.yoshino.model.ListNode;


public class P141LinkedListCycle {
//    public boolean hasCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            if (fast == slow) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * 使用双指针，可以遍历获取是否有循环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode twoStep = head;
        ListNode oneStep = head;
        while (twoStep != null && twoStep.next != null) {
            twoStep = twoStep.next.next;
            oneStep = oneStep.next;
            if (twoStep == oneStep) {
                return true;
            }
        }
        return false;
    }
}
