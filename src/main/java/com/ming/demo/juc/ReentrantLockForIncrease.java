package com.ming.demo.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Ming
 * @Date: 2021/1/26 15:12
 * @Description: 使用/未使用 ReentrantLock进行多线程累加操作
 * @Return: 未使用ReentrantLock结构小于5000，使用后结果等于5000
 */
public class ReentrantLockForIncrease {

	static int cnt = 0;

	public static ReentrantLock reentrantLock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			// 加锁
			reentrantLock.lock();
			try {
				reentrantLock.lockInterruptibly();
				int n = 10;
				while (n > 0) {
					cnt++;
					n--;
					System.out.println("当前线程为:" + Thread.currentThread().getName());
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				// 释放锁
				reentrantLock.unlock();
			}
		};
		Thread t1 = new Thread(r);
		t1.wait();
		t1.join();
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		Thread t4 = new Thread(r);
		Thread t5 = new Thread(r);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			//等待足够长的时间 确保上述线程均执行完毕
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		System.out.println(cnt);
	}
}
