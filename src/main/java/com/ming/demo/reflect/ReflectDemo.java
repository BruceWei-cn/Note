package com.ming.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Ming
 * @date 2021/7/2 13:50
 * @description: 反射操作测试
 */
public class ReflectDemo {

	/**
	 *  Java 中的一大利器 注解 的实现也用到了反射。
	 *  <P>可以基于反射分析类，然后获取到类/属性/方法/方法的参数上的注解。你获取到注解之后，就可以做进一步的处理。</P>
	 *  <p>弊端：参加安全性问题； 可以无视反省参数安全检查（泛型擦除）；性能较差</p>
	 */
	public static void main(String[] args)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
		/**
		 * 获取TargetObject类的class对象并创建TargetObject实例
		 */
		Class<?> targetClass = Class.forName("com.ming.demo.reflect.TargetObject");
		// 创建实例
		TargetObject targetObject = (TargetObject) targetClass.newInstance();
		// 获取指定方法
		Method[] methods = targetClass.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("method = " + method.getName());
		}

		// 根据指定方法名获取方法
		Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
		// 根据创建的实例及参数调用方法
		publicMethod.invoke(targetObject,"Ming");

		// 反射可以调用私有类的私有方法
		Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
		// 为了调用类中的private私有方法，我们取消安全检查
		privateMethod.setAccessible(true);
		privateMethod.invoke(targetObject);

		/**
		 * 获取指定参数并对参数进行修改
		 */
		Field field = targetClass.getDeclaredField("value");
		field.setAccessible(true);
		field.set(targetObject,"See you!");
		privateMethod.invoke(targetObject);
	}
}
