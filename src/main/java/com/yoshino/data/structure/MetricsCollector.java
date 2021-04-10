package com.yoshino.data.structure;


import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MetricsCollector {
    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;

    private EventBus eventBus;

    public MetricsCollector() {
        this(DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    public MetricsCollector(int threadNumToSaveData) {
        this.eventBus = new AsyncEventBus(new ThreadPoolExecutor(threadNumToSaveData, threadNumToSaveData,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>()));
        this.eventBus.register(new EventListener());
    }

    public void recordRequest(String requestInfo) {
        eventBus.post(requestInfo);
    }

    public class EventListener {
        @Subscribe
        public void saveRequestInfo(String requestInfo) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(requestInfo);
        }
    }

    public static void main(String[] args) {
        MetricsCollector collector = new MetricsCollector();
        for (int i = 0; i < 2110000000; i++) {
            collector.recordRequest("shuchu" + i);
            if (i % 10000000 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("main");
    }
}
