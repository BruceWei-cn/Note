package com.ming.demo.design.pattern.observe;

/**
 * 观察者的继承者
 */
public class BinaryObserver extends Observer {

	private final Subject subject;

	/**
	 * 观察者订阅主题
	 */
	public BinaryObserver(Subject subject) {
		this.subject = subject;
		// 当订阅时，将观察者注册到订阅中心
		this.subject.attach(this);
	}

	/**
	 * 当观察到订阅中心变化，观察者做相应逻辑操作
	 */
	@Override
	public void update() {
		String result = Integer.toBinaryString(subject.getState());
		System.out.println("订阅的数据发生变化，新的数据处理为二进制值为：" + result);
	}
}