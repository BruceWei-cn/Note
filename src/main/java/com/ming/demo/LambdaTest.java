package com.ming.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/1/7 10:51
 * @Description: lambda
 */
public class LambdaTest {


	@Test
	public void test01() {
		List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
				"hello world welcome");
		// map
		list.stream().map(item -> Arrays.stream(item.split(" "))).distinct()
				.collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("################################");
		// flatMap
		list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct()
				.collect(Collectors.toList()).forEach(System.out::println);

		String[] s = {"hello welcome", "world hello", "hello world",
				"hello world welcome"};
		// 数组转化为list,该方法不适用与基本数据类型
		List<String> list1 = Arrays.asList(s);

	}

	@Test
	public void test02() {
		String[] strs = {"java8", "is", "easy", "to", "use"};
		// 映射成为Stream<String[]>
		List<String[]> distinctStrs = Arrays.stream(strs)
				.map(str -> str.split(""))
				.distinct().collect(Collectors.toList());
		System.out.println(distinctStrs);
		System.out.println("**********************");
		List<String> strings = Arrays.stream(strs)
				// 映射成为Stream<String[]>
				.map(str -> str.split(""))
				// 扁平化为Stream<String>
				.flatMap(Arrays::stream)
				.distinct().collect(
						Collectors.toList());
		System.out.println("strings = " + strings);
	}

	@Test
	public void test03() {
		ArrayList<BigDecimal> bigDecimals = new ArrayList<>();
		bigDecimals.add(BigDecimal.valueOf(1.03));
		// BigDecimal.ZERO：Initial data  ,BigDecimal::add: -> accumulator
		BigDecimal reduce = bigDecimals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("reduce = " + reduce);
	}

	@Test
	public void test04(){
		double a =25/2;
		System.out.println("a = " + a);
	}
}
