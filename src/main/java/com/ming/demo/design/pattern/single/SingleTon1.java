package com.ming.demo.design.pattern.single;

/**
 * @author: Ming
 * @Date: 2021/3/9 18:02
 * @Description: 简单的单例模式
 */
public class SingleTon1 {

	/**
	 * 空参构造私有化
	 */
	private SingleTon1(){
		throw new IllegalStateException();
	}

	/**
	 * 饿汉模式
	 * <p></p>
	 * 静态，当；类初始化则在内存中创建对象，空间换时间，不存在线程安全问题
	 */
	private static SingleTon1 instance = new SingleTon1();

	public static SingleTon1 getInstance(){
		return instance;
	}
}
