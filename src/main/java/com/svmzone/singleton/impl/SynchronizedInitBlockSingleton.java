package com.svmzone.singleton.impl;

import com.svmzone.singleton.Utils;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedInitBlockSingleton {

    private static SynchronizedInitBlockSingleton instance;
    public static AtomicInteger instanceCount = new AtomicInteger();

    private SynchronizedInitBlockSingleton() {
        Utils.initialize();
        instanceCount.incrementAndGet();
    }

    public static SynchronizedInitBlockSingleton getInstance() {
        if (instance == null) {
            synchronized (SynchronizedInitBlockSingleton.class) {
                instance = new SynchronizedInitBlockSingleton();
            }
        }
        return instance;
    }
}
