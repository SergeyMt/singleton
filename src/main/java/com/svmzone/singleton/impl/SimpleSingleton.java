package com.svmzone.singleton.impl;

import com.svmzone.singleton.Utils;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleSingleton {

    public static AtomicInteger instanceCount = new AtomicInteger();
    private static SimpleSingleton instance;

    private SimpleSingleton() {
        Utils.initialize();
    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
            instanceCount.incrementAndGet();
        }
        return instance;
    }
}
