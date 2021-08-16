package com.ming.demo.design.pattern.single;

/**
 * @author: Ming
 * @Date: 2021/3/9 18:09
 * @Description:
 */
public class SingleTon2 {

	private SingleTon2() {
		throw new IllegalStateException();
	}

	private static SingleTon2 instance = null;

	/**
	 * 懒汉模式
	 * <P></P>
	 * 方法被调用后才创建对象，以时间换空间，但是这样写再多线程模式下存在风险
	 * @return
	 */
	public static SingleTon2 getInstance() {
		if (instance == null) {
			instance = new SingleTon2();
		}
		return instance;
	}

}
