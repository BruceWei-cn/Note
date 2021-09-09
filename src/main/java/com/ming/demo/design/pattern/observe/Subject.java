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

	private List<Observer> observers = new ArrayList<>();
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
