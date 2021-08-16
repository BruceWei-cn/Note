package com.ming.demo.design.pattern.flyweight;

import java.util.HashMap;

/**
 * @author: Ming
 * @Date: 2021/4/8 15:16
 * @Description: 享元模式工厂： 运用共享技术有效的支持大量细粒度的对象 1.享元模式主要用于减少创建对象的数量，减少内存占用提高性能的结构模式
 * 2.享元模式尝试重用现有的同类对象，若未找到匹配的对象则创建新对象
 *
 * 应用实例：JAVA中的String如果有则返回，如果没有则创建一个字符串保存在字符串缓存池内
 */
public class ShapeFactory {

	/**
	 * 享元模式工厂： 运用共享技术有效的支持大量细粒度的对象
	 * <p>1.享元模式主要用于减少创建对象的数量，减少内存占用提高性能的结构模式</p>
	 * <p>2.享元模式尝试重用现有的同类对象，若未找到匹配的对象则创建新对象</p>
	 *
	 *
	 * <p>应用实例：JAVA中的String如果有则返回，如果没有则创建一个字符串保存在字符串缓存池内</p>
	 */
	private static final HashMap<String, Shape> circleMap = new HashMap<>();

	public static Shape getCircle(String color) {
		Circle circle = (Circle) circleMap.get(color);
		if (circle == null) {
			circle = new Circle(color);
			circleMap.put(color, circle);
//			System.out.println("Creating circle of color = " + color);
		}
		return circle;
	}
}
