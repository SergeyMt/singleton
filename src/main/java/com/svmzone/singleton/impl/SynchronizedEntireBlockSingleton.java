package com.svmzone.singleton.impl;

import com.svmzone.singleton.Utils;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedEntireBlockSingleton {

    private static SynchronizedEntireBlockSingleton instance;
    public static AtomicInteger instanceCount = new AtomicInteger();

    private SynchronizedEntireBlockSingleton() {
        Utils.initialize();
        instanceCount.incrementAndGet();
    }

    public static SynchronizedEntireBlockSingleton getInstance() {
        synchronized (SynchronizedEntireBlockSingleton.class) {
            if (instance == null) {
                instance = new SynchronizedEntireBlockSingleton();
            }
        }
        return instance;
    }
}
