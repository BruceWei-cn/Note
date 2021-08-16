package com.ming.demo.design.pattern.strategy.yesstratery;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/6/9 11:36
 * @Description:
 */
public class ShareFactory {

	enum ShareType{
			SINGLE("single", "单商品"),
			MULTI("multi", "多商品"),
			ORDER("order", "下单");

			private String code;
			private String desc;

			ShareType(String code,
					String desc) {
				this.code = code;
				this.desc = desc;
			}
			public String getCode() {
				return code;
			}
	}

	/**
	 * 使用策略模式定义一个分享工厂，策略模式属于行为设计模式，主要针对不同的做出策略做出对应的行为达到解耦
	 * <p/>原理：定义一系列算法，封装，并是他们可以转换不同策略可以让算法独立于使用它们的客户而变化
	 * <p/>好处： 策略模式可以实现自由切换，扩展性娘好，加一个策略只需要增加一个类
	 * <p/>缺点： 策略类过多，需要额外维护枚举类
	 */
	// 定义一个map，作为策略的缓存
	private static Map<String,ShareStrategy> shareStrategyMap = new HashMap<>();
	// 静态代码块，随着类加载而加载
	static {
		shareStrategyMap.put("single",new SingleItemShare());
		shareStrategyMap.put("order",new OrderItemShare());
		shareStrategyMap.put("multi",new MultiItemShare());
	}

	// 根据类型获取指定策略类型
	public static ShareStrategy getShareStrategy(String type){
		if (type == null || type.isEmpty()){
			throw new IllegalArgumentException("type should not be empty!!!");
		}
		return shareStrategyMap.get(type);
	}

	/**
	 * 第一种：使用缓存方式做策略模式的测试
	 */
	public static void main(String[] args) {
		// 模拟测试
		String shareType = "multi";
		// 根据类型返回具体执行类
		ShareStrategy shareStrategy = ShareFactory.getShareStrategy(shareType);
		System.out.println("shareStrategy = " + shareStrategy);
		shareStrategy.shareAlgorithm(shareType);
	}

	/**
	 * 第二种：使用策略类来模拟测试
	 */
	@Test
	public void strategyTest(){
		Context context = new Context(new MultiItemShare());
		context.execute("multi");
	}
}
