package com.yoshino.p1001to1100;

import com.yoshino.model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1019NextGreaterNodeInLinkedList {

    /**
     * 一次遍历，使用单调栈，与运算符类似
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> res = new ArrayList<>();
        Stack<int[]> tmp = new Stack<>();

        int count = 0;
        while (head != null) {
            res.add(0);
            while (!tmp.isEmpty() && tmp.peek()[0] < head.val) {
                int[] item = tmp.pop();
                res.set(item[1], head.val);
            }
            tmp.push(new int[]{head.val, count});
            count++;
            head = head.next;
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
