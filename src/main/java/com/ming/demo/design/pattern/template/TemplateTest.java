package com.ming.demo.design.pattern.template;

/**
 * @author Ming
 * @date 2021/9/3 12:02
 * @description
 */
public class TemplateTest {

	/**
	 * 模板方法模式的应用：模板方法只负责第一步做什么，第二步骤做什么，第三步做什么；但具体怎么做由子类来具体实现
	 */
	public static void main(String[] args) {
		AbstractTemplate t = new ConcreteTemplate();
		t.templateMethod();
	}
}
