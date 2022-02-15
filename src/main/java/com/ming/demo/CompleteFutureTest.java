package com.ming.demo;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Ming
 * @date 11/2/2022-上午 11:22
 */
public class CompleteFutureTest {

    @Test
    public void demo() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> async = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("任务异常");
            }
            System.out.println("任务结束");
            return 1;
        });
        System.out.println("async = " + async.get());
        Thread.sleep(3500);
        System.out.println("主线程结束");
    }
}
