package com.ming.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/3/9 11:04
 * @Description:
 */
public class StreamTest {

	@Test
	public void test01(){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers.parallelStream()
				.forEach(System.out::println);
	}

	@Test
	public void test02(){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers.forEach(System.out::println);
	}

	@Test
	public void test03(){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers.stream().parallel().forEachOrdered(System.out::println);
	}

	/**
	 * 一些说明： 本测试是为了测试 parallelStream并行流底层会调用多个线程来执行
	 * ParallelStreams使用JVM默认的forkJoin框架的线程池-> 分治思想
	 * <P></P>
	 * 补充：countDownLatch是一个计数器，此类作用使一个线程等待其他线程各自执行完毕后再执行
	 * @throws InterruptedException
	 */
	@Test
	public void test04() throws InterruptedException {
		// 构造一个10000个元素的集合
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}
		// 统计并行执行list的线程
		Set<Thread> threadSet = new CopyOnWriteArraySet<>();
		// 并行执行
		list.parallelStream().forEach(integer -> {
			// parallelStream并行流会用多个线程（线程数不定），去掉只有一个主进程
			Thread thread = Thread.currentThread();
//			 System.out.println(thread);
			threadSet.add(thread);
		});
		System.out.println("threadSet一共有" + threadSet.size() + "个线程");
		System.out.println("系统一个有"+Runtime.getRuntime().availableProcessors()+"个cpu");
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < 200000; i++) {
			list1.add(i);
			list2.add(i);
		}
		Set<Thread> threadSetTwo = new CopyOnWriteArraySet<>();
		CountDownLatch countDownLatch = new CountDownLatch(2);
		Thread threadA = new Thread(() -> {
			list1.parallelStream().forEach(integer -> {
				Thread thread = Thread.currentThread();
				// System.out.println("list1" + thread);
				threadSetTwo.add(thread);
			});
			countDownLatch.countDown();
		});
		Thread threadB = new Thread(() -> {
			list2.parallelStream().forEach(integer -> {
				Thread thread = Thread.currentThread();
				// System.out.println("list2" + thread);
				threadSetTwo.add(thread);
			});
			countDownLatch.countDown();
		});

		threadA.start();
		threadB.start();
		//调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
		countDownLatch.await();
		System.out.print("threadSetTwo一共有" + threadSetTwo.size() + "个线程");

/*		System.out.println("---------------------------");
		System.out.println(threadSet);
		System.out.println(threadSetTwo);
		System.out.println("---------------------------");
		threadSetTwo.addAll(threadSet);
		System.out.println(threadSetTwo);
		System.out.println("threadSetTwo一共有" + threadSetTwo.size() + "个线程");
		System.out.println("系统一个有"+Runtime.getRuntime().availableProcessors()+"个cpu");*/
	}

}
