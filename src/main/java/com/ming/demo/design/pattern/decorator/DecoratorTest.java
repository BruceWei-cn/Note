package com.ming.demo.design.pattern.decorator;

import com.ming.demo.design.pattern.decorator.beverage.Beverage;
import com.ming.demo.design.pattern.decorator.beverage.BlackTea;
import com.ming.demo.design.pattern.decorator.condiment.Lemon;
import com.ming.demo.design.pattern.decorator.condiment.Mango;

/**
 * @author Ming
 * @date 2021/7/28 14:24
 * @description 装饰器模式测试类
 */
public class DecoratorTest {

	/**
	 * 装饰器模式：主要基类 Beverage-饮料类， 客户可以选择调料品种的加入
	 * <p>调料作为装饰，装饰了饮料</p>
	 */
	public static void main(String[] args) {
		// 基础饮料
		Beverage beverage = new BlackTea();

		// 开始装饰
		// 加一份柠檬
		Lemon lemon = new Lemon(beverage);
		// 再加一份芒果
		Mango mango = new Mango(lemon);
		System.out.println("mango = " + mango.getDescription() + "; 总花费 = " + mango.getCost());

		// 开始装饰
		beverage = new Lemon(beverage);
		beverage = new Mango(beverage);
		System.out.println("beverage = " + beverage.getDescription() + "; 总花费 = " + beverage.getCost());
	}
}
