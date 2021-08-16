package com.ming.demo.design.pattern.decorator.condiment;

import com.ming.demo.design.pattern.decorator.beverage.Beverage;

/**
 * @author Ming
 * @date 2021/7/28 14:12
 * @description 装饰器模式：具体装饰类 -> 调料类
 */
public class Mango extends Condiment {

	private Beverage beverage;

	/**
	 * 构造函数
	 */
	public Mango(Beverage beverage) {
		this.beverage = beverage;
	}

	/**
	 * @return 返回描述
	 */
	@Override
	public String getDescription() {
		return beverage.getDescription() + ",加芒果";
	}

	/**
	 * @return 饮料加芒果，每份芒果加价3元
	 */
	@Override
	public Integer getCost() {
		return beverage.getCost() + 3;
	}
}
