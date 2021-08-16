package com.ming.demo.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Ming
 * @Date: 2021/1/25 11:30
 * @Description:
 */
public class CountDownLatchTest {

	/**
	 * 倒计时器，作用：可以将一个复杂的任务拆分为N个子线程的任务，state初始化也为N
	 *  * 每个子线程完成调用一次countDown()一次state-1,当state=0时await()函数放行 主进程向下运行;
	 *
	 *  <p>truAcquireShared：返回1代表子任务结束，主任务获取到锁（返回正数代表获取到锁同时唤醒后续节点;
	 *  共享模式下可能有多个主任务等待子任务完成，所以得全部唤醒）</p>
	 *  <p>countDownLatch：共享锁模式，子任务不断释放锁，主任务不断检查锁释放情况的过程。以此来实现主任务等待子任务完成的效果。</p>
	 */
	public static void main(String[] args) {

		/**
		 * state = 2,设置两个子线程去执行操作，每个完成后执行 countDown():state-1
		 */
		CountDownLatch downLatch = new CountDownLatch(2);
		System.out.println("主线程开始");
		ExecutorService es1 = Executors.newSingleThreadExecutor();
		es1.execute(() -> {
			try {
				Thread.sleep(3000);
				System.out.println("子线程：" + Thread.currentThread().getName() + "执行");
			} catch (InterruptedException e) {
				// 正确终端异常的线程
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			downLatch.countDown();
		});
		es1.shutdown();
		ExecutorService es2 = Executors.newSingleThreadExecutor();
		es2.execute(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			System.out.println("子线程：" + Thread.currentThread().getName() + "执行");
			downLatch.countDown();
		});
		es2.shutdown();
		System.out.println("等待两线程执行完毕");
		try {
			// 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行；await(1,TimeUnit.SECONDS))和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
			// 首先main线程会调用await()操作，main线程会被addWaiter()加入到等待队列，此时main线程会阻塞等待被唤醒
			downLatch.await();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		System.out.println("两个子线程都执行完毕，继续执行主线程");
	}
}
