package com.ming.demo.design.pattern.template;

/**
 * @author Ming
 * @date 2021/9/3 11:58
 * @description
 */
public class ConcreteTemplate extends AbstractTemplate {

	/**
	 * 抽象方法，子类必修重写
	 */
	@Override
	protected void apply() {
		System.out.println("子类重写了app()方法");
	}

	/**
	 * 非抽象方法，非必须重写，但子类若是想用此方法必须重写
	 */
	@Override
	protected void end() {
		System.out.println("子类重写的了end()方法");
	}
}
