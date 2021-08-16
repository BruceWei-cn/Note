package com.ming.demo.design.pattern.flyweight;

/**
 * @author: Ming
 * @Date: 2021/4/8 15:20
 * @Description: 享元工厂模式测试类
 */
public class FlyweightPatternDemo {

	private static final String[] COLORS = {"Red", "Green", "Blue", "White", "Black"};

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			// 使用享元工厂，通过传递颜色信息来获取实体类的对象
			// 享元模式避免每次都创建同样的新对象，减少内存开销
			Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}

	private static String getRandomColor() {
		return COLORS[(int) (Math.random() * COLORS.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}
}
