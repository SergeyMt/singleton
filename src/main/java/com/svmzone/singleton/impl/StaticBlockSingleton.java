package com.svmzone.singleton.impl;
import com.svmzone.singleton.Utils;

import java.util.concurrent.atomic.AtomicInteger;

public class StaticBlockSingleton {

    public static AtomicInteger instanceCount = new AtomicInteger();
    private static StaticBlockSingleton instance;

    static {
        if (instance == null) {
            instance = new StaticBlockSingleton();
        }
    }

    private StaticBlockSingleton() {
        Utils.initialize();
        instanceCount.incrementAndGet();
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

}
