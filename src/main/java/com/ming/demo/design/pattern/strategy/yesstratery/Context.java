package com.ming.demo.design.pattern.strategy.yesstratery;

import lombok.NoArgsConstructor;

/**
 * @author Ming
 * @date 2021/7/28 17:12
 * @description 策略本类
 */
@NoArgsConstructor
public class Context {

	private ShareStrategy strategy;

	/**
	 * 构造函数根据传递不同的策略来创建不同的”执行方式“类
	 * @param strategy 执行类的类型
	 */
	public Context(ShareStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 根据传递的"执行类"来执行相应方法
	 * @param param 参数
	 */
	public void execute(String param) {
		strategy.shareAlgorithm(param);
	}
}
