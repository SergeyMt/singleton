package com.svmzone.singleton;

import com.svmzone.singleton.impl.StaticBlockSingleton;
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
public class StaticBlockSingletonTest {

    @Test
    void StaticBlockSingleton() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Const.NUMBER_OF_THREADS);
        Collection<Callable<Object>> tasks = new LinkedList<>();
        for (int i = 0; i < Const.NUMBER_OF_THREADS; i++) {
            tasks.add(() -> StaticBlockSingleton.getInstance());
        }
        long execTime = System.currentTimeMillis();
        executor.invokeAll(tasks);
        System.out.println("Execution time: " + (System.currentTimeMillis() - execTime));
        assertEquals(1, StaticBlockSingleton.instanceCount.get(), "More than one instance was created");
    }
}
