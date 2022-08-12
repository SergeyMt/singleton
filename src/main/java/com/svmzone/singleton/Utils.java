package com.svmzone.singleton;

public class Utils {
    public static void initialize() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
