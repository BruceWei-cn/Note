package com.ming.demo.reflect;

/**
 * @author Ming
 * @date 2021/7/2 13:48
 * @description: 目标类
 */
public class TargetObject {

	private String value;

	public TargetObject() {
		value = "Yesterday Once More!";
	}

	public void publicMethod(String s) {
		System.out.println("I love " + s);
	}

	private void privateMethod() {
		System.out.println("value is " + value);
	}
}
