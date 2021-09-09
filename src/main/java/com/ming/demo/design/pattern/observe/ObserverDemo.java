package com.ming.demo.design.pattern.observe;

/**
 * 观察者模式的测试
 */
public class ObserverDemo {

	public static void main(String[] args) {
		// 先实例化一个主题
		Subject subject = new Subject();
		// 定义观察者，并向主题注册
		BinaryObserver binaryObserver = new BinaryObserver(subject);
		HexaObserver hexaObserver = new HexaObserver(subject);

		// 此时，数据变动
		subject.setState(10);
	}
}
