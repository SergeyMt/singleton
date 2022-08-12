package com.svmzone.singleton.impl;
import com.svmzone.singleton.Utils;

import java.util.concurrent.atomic.AtomicInteger;

public class StaticInitSingleton{

    public static AtomicInteger instanceCount = new AtomicInteger();
    private static StaticInitSingleton instance = new StaticInitSingleton();

    private StaticInitSingleton() {
        Utils.initialize();
        instanceCount.incrementAndGet();
    }

    public static StaticInitSingleton getInstance() {
        return instance;
    }

}
