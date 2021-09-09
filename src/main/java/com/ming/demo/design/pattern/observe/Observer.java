package com.ming.demo.design.pattern.observe;

/**
 * 观察者
 * <P>观察者会被注册到订阅中心去，当观察到订阅中心数据变化，观察者需要做相应逻辑操作</P>
 */
public abstract class Observer {

//	protected Subject subject;

	/**
	 * 当观察到数据变化做逻辑操作
	 */
	public abstract void update();
}