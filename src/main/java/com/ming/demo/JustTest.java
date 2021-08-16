package com.ming.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/7/20 13:38
 * @description 无法区分的测试放在此类中
 */
public class JustTest {

	/**
	 * 测试泛型擦除
	 * <P>框架中也大量使用了动态代理，而动态代理的实现也依赖反射(动态代理：通过反射获取目标类，进行增加额外操作等)。</P>
	 *
	 * <p>为什么你使用 Spring 的时候 ，一个@Component注解就声明了一个类为 Spring Bean 呢？为什么你通过一个 @Value注解就读取到配置文件中的值呢？究竟是怎么起作用的呢？
	 *
	 * <P> 这些都是因为你可以基于反射分析类，然后获取到类/属性/方法/方法的参数上的注解。你获取到注解之后，就可以做进一步的处理(比如spring的AOP)。
	 */
	@Test
	public void reflectTest()
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		ArrayList<Integer> list = new ArrayList<>();
		// 报错类型不符
//		list.add("A");

		Class<? extends ArrayList> clazz = list.getClass();
		Method add = clazz.getDeclaredMethod("add", Object.class);
		// 通过反射添加不同类型的值，可以
		add.invoke(list,"A");
		System.out.println("list = " + list);
	}
}
