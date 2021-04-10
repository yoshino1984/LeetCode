package com.yoshino.data.structure;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangxin
 * 2021/3/18 13:12
 * @since
 **/
class BoundedBlockingQueue<T> {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final LinkedList<T> elementData;
    private final AtomicInteger size = new AtomicInteger();
    private final int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        elementData = new LinkedList<>();
    }

    public void enqueue(T element) throws InterruptedException {
        lock.lock();
        try {
            while (isFull()) {
                notFull.await();
            }
            elementData.addFirst(element);
            size.incrementAndGet();
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (isEmpty()) {
                notEmpty.await();
            }
            size.decrementAndGet();
            notFull.signalAll();
            return elementData.removeLast();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return size.get();
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() >= capacity;
    }
}
