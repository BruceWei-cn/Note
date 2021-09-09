package com.ming.demo.design.pattern.observe;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 主题
 */
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

	/**
	 * 于final修饰的变量来说，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
	 * 如果是引用类型的变量，是指引用变量不能变，引用变量所指向的对象中的内容还是可以改变的，也就是说在对其初始化之后便不能再让其指向另一个对象。
	 */
	private final List<Observer> observers = new ArrayList<>();
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		// 数据已变更，通知观察者们
		notifyAllObservers();
	}

	/**
	 * 注册观察者们
	 */
	public void attach(Observer observer) {
		observers.add(observer);
	}

	/**
	 * 钩子方法，回调，通知观察者们
	 */
	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
