package com.ming.demo.design.pattern.decorator.beverage;

/**
 * @author Ming
 * @date 2021/7/28 14:03
 * @description 装饰器模式：定义饮料抽象基类
 */
public abstract class Beverage {

	/**
	 * @return 返回描述
	 */
	public abstract String getDescription();

	/**
	 * @return 返回价格
	 */
	public abstract Integer getCost();
}
