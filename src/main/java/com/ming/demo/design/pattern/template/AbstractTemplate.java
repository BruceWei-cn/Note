package com.ming.demo.design.pattern.template;

/**
 * @author Ming
 * @date 2021/9/3 11:46
 * @description 模板方法模式的抽象类
 */
public abstract class AbstractTemplate {

	/**
	 * 模板设计模式的模板方法方法
	 * <P>模板方法模式只负责要做什么及做的步骤，但具体怎么做由子类来决定实现</P>
	 */
	public void templateMethod() {
		init(); // 第一步
		apply(); // 第二步
		end(); // 第三步（可以作为钩子函数）
	}

	protected void init() {
		System.out.println("init 抽象层已经实现，子类也可以选择复写");
	}

	/**
	 * 抽象方法，子类必修重写
	 */
	protected abstract void apply();

	/**
	 * 非抽象方法，非必须重写，但子类若是想用此方法必须重写
	 */
	protected void end() {
		throw new UnsupportedOperationException("end() method must be override!");
	}
}
