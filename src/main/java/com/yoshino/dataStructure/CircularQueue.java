package com.yoshino.dataStructure;

public class CircularQueue<T> {

    private int n;
    private int head = 0;
    private int tail = 0;
    private T[] items;

    public CircularQueue(int capacity) {
        this.n = capacity;
        items = (T[]) new Object[capacity];
    }

    public boolean enqueue(T item) {
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public T dequeue() {
        if (head == tail) {
            return null;
        }
        T ret = items[head];
        head = (head + 1) % n;
        return ret;

    }

}
