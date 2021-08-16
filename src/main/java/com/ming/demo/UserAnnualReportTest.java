package com.ming.demo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;
import sun.rmi.runtime.Log;

/**
 * @author: Ming
 * @Date: 2020/12/18 10:57
 * @Description:
 */
public class UserAnnualReportTest {

	@Test
	public void test01() {
		BigDecimal bigDecimal = new BigDecimal(0);
		if (Objects.nonNull(bigDecimal)) {
			System.out.println("Hello World!");
		}

		// compareTo方法：如果BigDecimal为小于val返回-1，如果BigDecimal为大于val返回1，如果BigDecimal为等于val返回0
		int i = bigDecimal.compareTo(BigDecimal.ZERO);
		if (i == 1) {
			System.out.println("Hello World2!");
		}
	}

	@Test
	public void test02() {
		int likeNum = 679;
		int commNum = 655;
		int broNum = 1224;
		if (likeNum > 0) {
			System.out.println((likeNum * 1.0) / broNum);
		}
	}

	@Test
	public void test03() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = simpleDateFormat.parse("2020-12-1");
		Date date2 = simpleDateFormat.parse("2020-12-1");
		if (date2.after(date1)) {
			System.out.println("此用户是新用户！");
		}
		System.out.println(date2.after(date1));
	}

	@Test
	public void test05() {
		// 获取CPU 核心数
		int cupNums = Runtime.getRuntime().availableProcessors();
		System.out.println("cupNums = " + cupNums);

	}

	/**
	 * @author Ming
	 * @description 获取系统时间，两种方式，推荐第一种
	 */
	@Test
	public void test06() {
		// Positive example:
		long a = System.currentTimeMillis();
		// Negative example:
		long b = new Date().getTime();

		System.out.println(a);
		System.out.println(b);
	}

	@Test
	public void test07() {
		String str = "[]";
		String strB = "[{\"url\": \"https://img.visvachina.com/2020-01-05/5bf7fad0756571006a0e6be4_df6b478159950702db7d3b1600a8efc6.png\", \"size\": 510921, \"width\": 750, \"format\": \"jpg\", \"height\": 1000}, {\"url\": \"https://img.visvachina.com/2020-01-05/5bf7fad0756571006a0e6be4_5ffe0cef072838c6e0d856c8fa22debb.png\", \"size\": 556129, \"width\": 750, \"format\": \"jpg\", \"height\": 1000}, {\"url\": \"https://img.visvachina.com/2020-01-05/5bf7fad0756571006a0e6be4_b5846aeca90af30be29b80dc6adb618d.png\", \"size\": 1141793, \"width\": 750, \"format\": \"jpg\", \"height\": 1000}, {\"url\": \"https://img.visvachina.com/2020-01-05/5bf7fad0756571006a0e6be4_262ab78f7b23d9d5002a8d96731c8984.png\", \"size\": 917029, \"width\": 750, \"format\": \"jpg\", \"height\": 1000}, {\"url\": \"https://img.visvachina.com/2020-01-05/5bf7fad0756571006a0e6be4_aad5868d890eef2b3fdf7cfac42fbae8.png\", \"size\": 811690, \"width\": 750, \"format\": \"jpg\", \"height\": 1000}, {\"url\": \"https://img.visvachina.com/2020-01-05/5bf7fad0756571006a0e6be4_92e0ae694de7e7cf325a4270740607eb.png\", \"size\": 926828, \"width\": 750, \"format\": \"jpg\", \"height\": 1000}]";
		if ("[]".equals(strB)) {
			System.out.println("str = " + str);
		}
	}

	@Test
	public void	test08(){
		String str ="";
		Integer flag = null;
		int a =0;
		if (Objects.nonNull(str)){
			System.out.println("AAA");
		}
		if (Objects.isNull(flag)){
			System.out.println("NNNN");
		}else if (a==0){
			System.out.println("GUIGIUGIU");
		}
	}

	@Test
	public void	test09(){
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
		scheduledExecutorService.schedule(() -> {
				System.out.println("你好");
		},3, TimeUnit.SECONDS);
	}

	@Test
	public void test10(){
		// false
		System.out.println(0>0);
	}
}
