package com.yoshino.leetcode.p601to650;

public class P641MyCircularDeque {

    private int[] elementData;
    private int capacity;
    private int front;
    private int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public P641MyCircularDeque(int k) {
        elementData = new int[k + 1];
        capacity = elementData.length;
        // 指向第一个有效元素
        front = 0;
        // 指向最后一个有效元素的后一位
        rear = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        elementData[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elementData[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : elementData[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : elementData[(rear - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public static void main(String[] args) {
        P641MyCircularDeque circularDeque = new P641MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));;			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        System.out.println(circularDeque.insertFront(4));;			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  			// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        System.out.println(circularDeque.getFront());				// 返回 4

    }
}

/**
 * Your P641MyCircularDeque object will be instantiated and called as such:
 * P641MyCircularDeque obj = new P641MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

