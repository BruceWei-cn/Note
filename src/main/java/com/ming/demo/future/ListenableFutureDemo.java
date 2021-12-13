package com.ming.demo.future;

import com.google.common.util.concurrent.*;
import lombok.extern.java.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Ming
 * @date 13/12/2021-下午 2:48
 */
@Log
public class ListenableFutureDemo {

    public static void main(String[] args) {

        /*
         * An ExecutorService that returns ListenableFuture instances. To create an instance from an existing ExecutorService
         */
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        // 执行任务
        ListenableFuture<String> listenableFuture = executorService.submit(() -> {
            log.info("新任务。。。");
            TimeUnit.SECONDS.sleep(2);
            return "s";
        });

        // 任务完成回掉函数
        FutureCallback<String> futureCallback = new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                log.info("任务执行成功，对任务进行操作。");
            }

            @Override
            public void onFailure(Throwable t) {
                log.info("任务执行失败");
            }
        };

        // 绑定任务以及回调函数,对的带Listenable实例进行监听
        Futures.addCallback(listenableFuture, futureCallback, executorService);
        executorService.shutdown();
    }
}
