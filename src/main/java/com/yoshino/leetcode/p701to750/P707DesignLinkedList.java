package com.yoshino.leetcode.p701to750;

public class P707DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));           //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3

    }
}

/**
 * 插入第一个节点和删除index节点时，需要考虑最后一个节点rear所指向的问题
 * 以下为单线程可用版本
 */
class MyLinkedList {
    ListNode front;
    ListNode rear;
    int size;


    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.front = new ListNode(-1);
        this.rear = this.front;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size <= index) {
            return -1;
        }
        ListNode cur = front;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = front.next;
        front.next = newNode;
        if (rear == front) {
            rear = newNode;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        rear.next = new ListNode(val);
        rear = rear.next;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else if (index < size) {
            ListNode newNode = new ListNode(val);
            ListNode cur = front;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        } else if (index == size) {
            addAtTail(val);
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            ListNode cur = front;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            if (cur.next == rear) {
                rear = cur;
            }
            cur.next = cur.next.next;
            size--;
            if (size == 0) {
                rear = front;
            }
        }
    }

    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */