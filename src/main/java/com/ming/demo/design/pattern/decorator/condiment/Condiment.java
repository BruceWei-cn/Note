package com.ming.demo.design.pattern.decorator.condiment;

import com.ming.demo.design.pattern.decorator.beverage.Beverage;

/**
 * @author Ming
 * @date 2021/7/28 14:14
 * @description 调料抽象类-基于饮料类的抽象抽象类
 */
public abstract class Condiment extends Beverage {

	/**
	 * @return 返回描述
	 */
	@Override
	public abstract String getDescription();

	/**
	 * @return 返回价格
	 */
	@Override
	public abstract Integer getCost();
}
