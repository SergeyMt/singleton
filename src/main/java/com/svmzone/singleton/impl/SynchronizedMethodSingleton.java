package com.svmzone.singleton.impl;

import com.svmzone.singleton.Utils;
import lombok.Synchronized;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedMethodSingleton {

    private static SynchronizedMethodSingleton instance;
    public static AtomicInteger instanceCount = new AtomicInteger();

    private SynchronizedMethodSingleton() {
        Utils.initialize();
        instanceCount.incrementAndGet();
    }

    @Synchronized
    public static SynchronizedMethodSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedMethodSingleton();
        }
        return instance;
    }
}
