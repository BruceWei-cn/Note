package com.ming.demo.design.pattern.single;

/**
 * @author: Ming
 * @Date: 2021/3/9 19:05
 * @Description:
 */
public class SingleTon4 {

	private SingleTon4(){
		throw new IllegalStateException();
	}

	/**
	 * 静态内部类
	 */
	private static class SingleTonHolder{
		private static SingleTon4 instance = new SingleTon4();
	}

	/**
	 * 静态内部类的优点是:外部类加载不需要立即加载内部类，内部类不被加载则不去初始化instance,所以不占内存
	 * 能确保线程安全，也能保证单例的唯一性，同时也延迟单例实例化
	 */
	public static SingleTon4 getInstance(){
		return SingleTonHolder.instance;
	}

	/**
	 * 此处引出一个问题：静态方法是否有线程安全性问题？
	 * 答案：
	 * 		1：若静态方法内没有静态变量，则没有线程安全；
	 * 			1.1：因为静态方法内声明非静态变量，每个线程都会单独创建一份，不会共用存储单元，所以安全；
	 *
	 * 		2：若静态方法内有静态变量，则会产生线程安全性问题；
	 * 			2.1：因为静态变量是会跟随类加载是占用一个存储区，每个线程操作此静态变量都是操作此共用存储区，
	 * 					所以会有线程安全；
	 *
	 * 反观 class SingleTon4 生成单列：
	 * 			getInstance()内是静态内部类，只会随着第一次调用被初始化，接下来获取单列都是从同一存储区
	 * 			获取同一单列，所以安全
	 *
	 */
}
