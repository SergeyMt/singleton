package com.svmzone.singleton;

import com.svmzone.singleton.impl.SynchronizedInitBlockSingleton;
import com.svmzone.singleton.impl.SynchronizedMethodSingleton;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SynchronizedMethodSingletonTest {

    @Test
    void SynchronizedMethodSingleton() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Const.NUMBER_OF_THREADS);
        Collection<Callable<Object>> tasks = new LinkedList<>();
        for (int i = 0; i < Const.NUMBER_OF_THREADS; i++) {
            tasks.add(() -> SynchronizedMethodSingleton.getInstance());
        }
        long execTime = System.currentTimeMillis();
        executor.invokeAll(tasks);
        System.out.println("Execution time: " + (System.currentTimeMillis() - execTime));
        assertEquals(1, SynchronizedMethodSingleton.instanceCount.get(), "More than one instance was created");

    }
}
