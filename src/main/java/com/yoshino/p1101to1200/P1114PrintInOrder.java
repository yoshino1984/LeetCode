package com.yoshino.p1101to1200;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * print in order 按序打印
 *
 * @author wangxin
 * 2020/4/6 09:12
 * @since
 **/
public class P1114PrintInOrder {

}

class Foo {
    private CountDownLatch firstJobIsDone = new CountDownLatch(1);
    private CountDownLatch secondJobIsDone = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobIsDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstJobIsDone.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobIsDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondJobIsDone.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}