package com.ming.demo.design.pattern.single;

/**
 * @author: Ming
 * @Date: 2021/3/9 18:15
 * @Description:
 */
public class SingleTon3 {

	private SingleTon3(){
		throw new IllegalStateException();
	}

	private static volatile SingleTon3 instance;

	/**
	 * 双重锁懒汉模式：DCL
	 * <p></p>
	 * 优点：再对象需要被使用的时候才创建，第一次判断空避免非必要加锁，节约内存保证线程安全
	 * 缺点：jvm会指令重排
	 * <p></p>
	 * 原因： instance = new SingleTon3();
	 *   1.在内存开辟空间
	 *   2.再堆内存中实例话SingleTon3
	 *   3.把对象指向堆内存空间
	 *可能在2还没执行就先执行步骤3，如此再切换到线程B,由于执行了3，instance已非空但就这样拿出来用会出现异常
	 *<p></p>
	 * 解决方案： volatile关键字，防指令重排 -> private volatile static SingleTon3 instance = null;
	 * volatile确保instance每次均在主内存中读取
	 */
	public static SingleTon3 getInstance(){
		if (instance == null){
			synchronized (SingleTon3.class){
				if (instance == null){
					instance = new SingleTon3();
				}
			}
		}
		return instance;
	}
}
