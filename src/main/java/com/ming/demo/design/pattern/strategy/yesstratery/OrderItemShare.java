package com.ming.demo.design.pattern.strategy.yesstratery;

/**
 * @author: Ming
 * @Date: 2021/6/9 11:33
 * @Description:
 */
public class OrderItemShare implements ShareStrategy {

	/**
	 * 定义分享策略执行方式
	 */
	@Override
	public void shareAlgorithm(String param) {
		System.out.println("当前分享的商品是：" + param);
	}
}
