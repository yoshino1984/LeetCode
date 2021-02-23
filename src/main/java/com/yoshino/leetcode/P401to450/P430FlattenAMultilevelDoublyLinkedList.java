package com.yoshino.leetcode.P401to450;

import com.yoshino.leetcode.model.Node;

import java.util.Stack;

public class P430FlattenAMultilevelDoublyLinkedList {

    /**
     * 使用栈存储上一层节点的后续信息，当处理完下层节点之后，出栈原来层次节点，依次遍历节点
     * 时间复杂度O(N)
     * 空间复杂度O(k) k<链表的层级
     * @param head
     * @return
     */
    public static Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Stack<Node> stack = new Stack<>();
        Node front = new Node();
        front.next = head;

        while (!(head.child == null && head.next == null && stack.isEmpty())) {
            if (head.child != null) {
                if (head.next != null) {
                    stack.push(head.next);
                }
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                head = head.next;
            } else if (head.next != null){
                head = head.next;
            } else {
                head.next = stack.pop();
                head.next.prev = head;
                head = head.next;
            }
        }

        return front.next;
    }

    public static void main(String[] args) {
        Node n3 = new Node();
        n3.val = 3;
        Node n2 = new Node();
        n2.val = 2;
        n2.child = n3;
        Node n1 = new Node();
        n1.val = 1;
        n1.next = n2;
        flatten(n1);

        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }

    }

}
