package com.yoshino.leetcode.p1101to1200;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * print in order 按序打印
 *
 * @author wangxin
 * 2020/4/6 09:12
 * @since
 **/
public class P1115PrintFoobarAlternately {

    class FooBar {
        private AtomicBoolean isBar = new AtomicBoolean(false);
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (isBar) {
                    while (isBar.get()) {
                        isBar.wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    isBar.set(true);
                    isBar.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (isBar) {
                    while (!isBar.get()) {
                        isBar.wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    isBar.set(false);
                    isBar.notifyAll();
                }
            }
        }
    }
}
