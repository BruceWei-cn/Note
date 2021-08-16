package com.ming.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable+Future/FutureTask 可以获取多线程运行的结果，可以在等待时间太长没获取到需要的数据的情况下取消该线程的任务，真的是非常有用。
 */
public class CallableThreadTest implements Callable<Integer> {

	/**
	 * 1、如上面代码所示，callable的核心是call方法，允许返回值，runnable的核心是run方法，没有返回值
	 * 2、call方法可以抛出异常，但是run方法不行
	 * 3、因为runnable是java1.1就有了，所以他不存在返回值，后期在java1.5进行了优化，就出现了callable，就有了返回值和抛异常
	 * 4、callable和runnable都可以应用于executors。而thread类只支持runnable
	 */
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CallableThreadTest ctt = new CallableThreadTest();
		// FutureTask继承了Runnable
		FutureTask<Integer> ft = new FutureTask<>(ctt);
		new Thread(ft, "有返回值的线程").start();
		System.out.println(ft.isDone());
		// FutureTask.get()：只有在计算完成后才能检索结果； 如果计算尚未完成，则get方法将阻塞。
		System.out.println("子线程的返回值 " + ft.get());
		System.out.println(ft.isDone());
		// 计算结束后，不会阻塞主进程，可正常输出
		System.out.println("AAAAA");
	}

	@Override
	public Integer call() throws InterruptedException {
		int i;
		for (i = 0; i < 10; i += 2) {
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		return i;
	}
}