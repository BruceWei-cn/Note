package com.ming.demo.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: Ming
 * @Date: 2021/6/22 13:41
 * @Description:
 */
public class CyclicBarrierTest {

	/**
	 * 请求数量
	 */
	private static final int THREAD_COUNT = 10;

	/**
	 * 需要同步线程的数量
	 */
	private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

	/**
	 * CyclicBarrier 和 CountDownLatch 非常类似，它也可以实现线程间的技术等待，但是它的功能比 CountDownLatch 更加复杂和强大。主要应用场景和 CountDownLatch 类似。
	 *<p></p>
	 * CountDownLatch 的实现是基于 AQS 的，而 CyclicBarrier 是基于 ReentrantLock(ReentrantLock 也属于 AQS 同步器)和 Condition 的.
	 *<p></p>
	 * CountDownLatch: 一个或者多个线程，等待其他多个线程完成某件事情之后才能执行
	 * <P>CyclicBarrier : 多个线程互相等待，直到到达同一个同步点，再继续一起执行。</P>
	 *
	 * <p></p>
	 * CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）。
	 * 它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。
	 * CyclicBarrier 默认的构造方法是 CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，每个线程调用await方法告诉 CyclicBarrier 我已经到达了屏障，然后当前线程被阻塞。
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread.sleep(1000);
			int threadNum = i;
			threadPool.execute(() -> {
				try {
					test(threadNum);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}

	public static void test(int threadNum)
			throws InterruptedException, TimeoutException, BrokenBarrierException {
		System.out.println("threadNum:" + threadNum + "is ready");
		// 计数子线程个数，每达到5个时主线程放行；计数reset可以重复使用
		cyclicBarrier.await(10, TimeUnit.SECONDS);
		System.out.println("threadNum:" + threadNum + "is finish");
	}
}
