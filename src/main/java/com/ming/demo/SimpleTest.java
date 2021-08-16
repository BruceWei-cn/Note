package com.ming.demo;

import com.google.common.collect.Lists;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import org.junit.Test;
import sun.misc.Cleaner;

/**
 * @author Ming
 */
public class SimpleTest {

	@Test
	public void testIp() throws UnknownHostException {
		InetAddress host = InetAddress.getByName("112.65.48.150");
		String hostName = host.getHostName();
		String hostAddress = host.getHostAddress();
		System.out.println("hostName = " + hostName);
		System.out.println("hostAddress = " + hostAddress);
	}

	@Test
	public void test() throws InterruptedException {
		Boolean success = 15 / 3 > 2;
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(1024);
		if (success) {
			System.out.println("你好");
		}
	}

	@Test
	public void test02() {
		// 2019-06-20 23:25:52
		Date date = new Date(1561044352000L);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("date = " + dateFormat.format(date));
	}

	@Test
	public void test03() {
		List<String> list = Arrays.asList("a,b,c", "1,2,3");
		//将每个元素转成一个新的且不带逗号的元素
		// map: 接受一个函数作为参数，该函数会被应用道每个元素上，将其映射成一个新的元素
		Stream<String> s1 = list.stream().map(s -> s.replaceAll(",", ""));
		// 输出：abc  123
		s1.forEach(System.out::println);

		Stream<String> s3 = list.stream().flatMap(s -> {
			//flatMap:将每个元素转换成一个stream,然后把所有流拼接陈给一个流
			String[] split = s.split(",");
			Stream<String> s2 = Arrays.stream(split);
			return s2;
		});
		s3.forEach(System.out::println);
	}

	@Test
	public void test05() {
		int i;
		int[] a = new int[6];
		for (i = 0; i <= 5; i++) {
			a[i] = i;
		}
		for (i = 5; i >= 0; i--) {
			System.out.print(a[i]);
		}
	}

	@Test
	public void test06() {
		long millis = System.currentTimeMillis();
		System.out.println("millis = " + millis);
		Date date = new Date(millis);
		System.out.println("date = " + date);
	}

	@Test
	public void test07() {
		double a = 23.653333;
		double b = 23.66;
		System.out.println(a < b);
		System.out.println(Double.valueOf(a * 100).intValue());
		System.out.println((int) (a * 100));

	}

	@Test
	public void test08() {
		int a = 2361;
		System.out.println((double) a / 100);
	}

	@Test
	public void test09() {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 2);
		System.out.println("map = " + map.toString());
	}

	@Test
	public void test10() {
		// Set:注重独一无二的性质，存储元素是无序的，不可重复的。
		// HashSet: 无序唯一，基于HashMap实现的，底层采用hashMap来保存元素；key为存入值，value为底层定义虚拟之Object
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add(4);
		System.out.println("hashSet = " + hashSet);
		Iterator<Integer> iterator = hashSet.iterator();

	}

	@Test
	public void test11() {
		// 浮点运算，无限大 -> Infinity
		System.out.println(1.0 / 0.0);
	}

	@Test
	public void test12() {
		ArrayList<Integer> list = Lists.newArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println("list = " + list);
		System.out.println("list = " + list.toString());
		System.out.println("[1, 2, 3]".equals(list.toString())); // true
	}

	@Test
	public void dateTest(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = dateFormat.format(new Date());
		System.out.println("format = " + format);
		Integer a =1;
		int b =1;
		System.out.println(a == b);

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE,-1);

		System.out.println(dateFormat.format(calendar.getTime()));
	}
}
