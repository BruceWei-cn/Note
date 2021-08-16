package com.ming.demo.juc.semaphore;

import java.util.concurrent.Semaphore;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/6/15 15:47
 * @Description:
 */
public class SemaphoreTest {

	@Test
	public void test01() throws InterruptedException {
		Semaphore semaphore = new Semaphore(0);
		semaphore.release();
		System.out.println("当前可用信号量个数为：" + semaphore.availablePermits());
		semaphore.acquire();
		System.out.println("当前可用信号量个数为：" + semaphore.availablePermits());
		semaphore.release();
		System.out.println("当前可用信号量个数为：" + semaphore.availablePermits());
	}
}
