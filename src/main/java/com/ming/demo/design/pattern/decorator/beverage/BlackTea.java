package com.ming.demo.design.pattern.decorator.beverage;

/**
 * @author Ming
 * @date 2021/7/28 14:06
 * @description 基础类继承抽象类
 */
public class BlackTea extends Beverage {

	/**
	 * @return 返回描述
	 */
	@Override
	public String getDescription() {
		return "黑茶";
	}

	/**
	 * @return 返回价格
	 */
	@Override
	public Integer getCost() {
		return 10;
	}
}
