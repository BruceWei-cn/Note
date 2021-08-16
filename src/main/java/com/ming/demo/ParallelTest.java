package com.ming.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * @author Ming
 */
public class ParallelTest {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newCachedThreadPool();
		CountDownLatch cdl = new CountDownLatch(100);
		for (int i = 0; i < 100; i++) {
			CountRunnable runnable = new CountRunnable(cdl);
			pool.execute(runnable);
		}
		pool.shutdown();
	}
}

@AllArgsConstructor
class CountRunnable implements Runnable {

	private final CountDownLatch countDownLatch;

	@SneakyThrows
	@Override
	public void run() {
		// synchronized锁具有可重入性；其锁对象的时候有计数器会记录线程获取锁的次数，执行对应 代码块后计数器-1，直到清零释放锁
		// synchronized不可中断性，一个线程获取锁之后，另外一个线程处于阻塞或者等待状态，前一个不释放，后一个也一直会阻塞或者等待，不可以被中断。
		synchronized (countDownLatch) {
			/** 每次减少一个容量*/
			countDownLatch.countDown();
			System.out.println("thread counts = " + (countDownLatch.getCount()));
		}
		countDownLatch.await();
	}
}