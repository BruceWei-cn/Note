package com.ming.demo.threadlocal;

import java.text.SimpleDateFormat;
import lombok.SneakyThrows;

/**
 * @author: Ming
 * <P>非常好的讲解ThreadLocal的文章：https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/multi-thread/%E4%B8%87%E5%AD%97%E8%AF%A6%E8%A7%A3ThreadLocal%E5%85%B3%E9%94%AE%E5%AD%97.md</P>
 */
public class ThreadLocalTest implements Runnable {

	/**
	 * SimpleDateFormat不是线程安全的，所以每个线程都要有自己独立的副本
	 * <hr><blockquote>
	 * <P>1.在同⼀个线程中声明了两个 ThreadLocal 对象的话，会使⽤调用getMap()方法获取threadLocals(ThreadLocalMap)</P>
	 * <P>2.再通过map.getEntry(this.threadLocal)获取到该threadLocal对应的Entry实体，
	 * 		(map底层结果是多个Entry组成的table，threadLocal.get()查找的时候是根据hashcode找到该table上对应的Entry再获取Entry.value);</P>
	 * <P>3.ThreadLocalMap中有多个Entry:单个线程设置(set)多个ThreadLocal就会在此map上用线性探测法存入多个Entry;</P>
	 * <P>4.每个Entry的key：this.threadLocal,value:set()时塞入的值</P>
	 * <hr><blockquote>
	 * ThreadLocalMap.Entry 中的 key:this.ThreadLocal 为WeakReference引⽤,⽽ value 是强引⽤。所以，如果
	 * ThreadLocal 没有被外部强引⽤的情况下，在垃圾回收的时候，key 会被清理掉，⽽ value 不会被
	 * 清理掉。这样⼀来， ThreadLocalMap.Entry 中就会出现key为null的Entry。假如我们不做任何措施的话，
	 * value 永远⽆法被GC 回收，这个时候就可能会产⽣内存泄露。ThreadLocalMap实现中已经考虑了这种
	 * 情况，在调⽤ set() 、 get() 、 remove() ⽅法的时候，会清理掉 key 为 null 的记录。使⽤完
	 * ThreadLocal ⽅法后 最好⼿动调⽤ remove() ⽅法
	 * <P>
	 *     注：在set()时会使用hash计算在整个table上找到适合存放Entry的位置；
	 *     若该位置不为null那么就会使用探测线性法查找距离该table最近的Entry.key为null的位置，并将新值存放在该位置，在此过程中会将key为null,value不为null的entry清除</P>
	 */
	private static final ThreadLocal<SimpleDateFormat> FORMATTER =
			ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

	@SneakyThrows
	public static void main(String[] args) {
		ThreadLocalTest localTest = new ThreadLocalTest();
		for (int i = 0; i < 2; i++) {
			synchronized (ThreadLocalTest.class) {
				Thread t = new Thread(localTest, "" + i + ":");
				Thread.sleep(1000);
				t.start();
			}
		}
		new Thread(() -> {
				System.out.println("just a test");
		}).start();
	}

	/**
	 * 每一个线程内 -> ThreadLocalMap 其内保存一个table，该table由多个Entry组成，每个Entry内部 -> Key: ThreadLocal(此处为：FORMATTER), Value: **(threadLocal调用set方法设置value的值)
	 */
	@Override
	public void run() {
		System.out.println(
				"Thread Name=" + Thread.currentThread().getName() + "default Formatter = " + FORMATTER.get()
						.toPattern());
		/*try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		//formatter pattern is changed here by thread, but it won't reflect to other threads
		FORMATTER.set(new SimpleDateFormat());
		System.out.println(
				"Thread Name=" + Thread.currentThread().getName() + " formatter = " + FORMATTER.get()
						.toPattern());
		FORMATTER.remove();
	}
}
