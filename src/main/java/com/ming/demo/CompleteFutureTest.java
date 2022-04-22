package com.ming.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

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


    /**
     * 异步 多线程的使用在批量运行获取最终结果时，还是需要一些计数器来做额外控制
     *
     * @throws InterruptedException
     */
    @Test
    public void demo02() throws InterruptedException {
        int ava = Runtime.getRuntime().availableProcessors();
        System.out.println("ava = " + ava);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 100, 5,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardPolicy());
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CompletableFuture.runAsync(() -> {
                list.add(getNum());
                latch.countDown();
            }, executor);
        }
        latch.await();
        System.out.println("list.size() = " + list.size());

        List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch latch2 = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                list2.add(getNum());
                latch2.countDown();
            });
        }
        latch2.await();
        System.out.println("list2.size() = " + list2.size());
    }

    private int getNum() {
        return 1;
    }
}
