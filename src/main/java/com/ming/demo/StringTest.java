package com.ming.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/2/7 11:14
 * @Description:
 */
public class StringTest {

	@Test
	public void test02() {
		String userAgent = "platform_android_system_10_app_1.9.0";
		String os_version = "";
		String os = "";
		String[] agents = userAgent.split("_");
		if (agents.length == 6) {
			os = agents[1];
			os_version = agents[3];
		}
		System.out.println("os = " + os);
		System.out.println("os_version = " + os_version);

		String version = agents[5].replace(".", "");
		int i = Integer.parseInt(version);
		System.out.println("i = " + i);
		System.out.println(i < 190);
	}

	@Test
	public void test03() {
		// 城市名祛除"市"单字 eg: "上海市" -> "上海"
		String cityName = "上海市";
		if (!"".equals(cityName) && Objects.nonNull(cityName) && Objects
				.equals(cityName.charAt(cityName.length() - 1), '市')) {
			cityName = cityName.substring(0, cityName.length() - 1);
		}
		System.out.println("cityName = " + cityName);
	}

	/**
	 * 替换字符串 ： 模糊用户信息
	 */
	@Test
	public void test05() {
		StringBuilder fuzzyStr = new StringBuilder("*");
		StringBuilder stringBuilder = new StringBuilder("浪");
		// length >=3
		if (stringBuilder.length() >= 3) {
			for (int i = 1; i < stringBuilder.length() - 2; i++) {
				fuzzyStr.append("*");
			}
			if (fuzzyStr.length() > 3) {
				fuzzyStr = new StringBuilder("***");
			}
			StringBuilder replace = stringBuilder
					.replace(1, stringBuilder.length() - 1, fuzzyStr.toString());
			System.out.println("replace = " + replace);
		}

		if (stringBuilder.length() == 2) {
			StringBuilder replace1 = stringBuilder.deleteCharAt(1).append("*");
			System.out.println("replace1 = " + replace1);
		}
		System.out.println("stringBuilder = " + stringBuilder);

	}

	@Test
	public void test06() {

		Map<String, String> data = new HashMap<>();
		data.put("name", "zhangs");
		data.put("code", "2222");
		String content = "恭喜${name}报名成功，请凭报名编号${code}到现场参加活动";
		String pattern = "\\$\\{(.+?)\\}";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(content);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String key = m.group(1);
			String value = data.get(key);
			m.appendReplacement(sb, value == null ? "" : value);
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}

	@Test
	public void test07(){
		String str = "狗子\uD83D\uDC36";
		System.out.println(filterUtf8mb4(str));
	}

	public String filterUtf8mb4(String str) {
		final int LAST_BMP = 0xFFFF;
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < str.length(); i++) {
			int codePoint = str.codePointAt(i);
			if (codePoint < LAST_BMP) {
				sb.appendCodePoint(codePoint);
			} else {
				// skip
				i++;
			}
		}
		return sb.toString();
	}

	@Test
	public void test08(){
		String s = "1000.00";
		String[] split = s.split("\\.");
		System.out.println("split = " + split[0]);
	}

	@Test
	public void test09(){
		String a = "a";
		String b = "b";
		String c = "ab";
		System.out.println((a+b) == c); // false

		System.out.println(("a"+ "b") == "ab"); //true
	}

	public String fuzzyUserNickname(String nickName) {
		if (Objects.isNull(nickName)){
			return "";
		}
		nickName = filterUtf8mb4(nickName);
		StringBuilder fuzzyStr = new StringBuilder("*");
		StringBuilder name = new StringBuilder(nickName);
		StringBuilder fuzzyName;
		// length >=3
		if (name.length() >= 3) {
			for (int i = 1; i < name.length() - 2; i++) {
				fuzzyStr.append("*");
			}
			if (fuzzyStr.length() > 3) {
				fuzzyStr = new StringBuilder("***");
			}
			fuzzyName = name
					.replace(1, name.length() - 1, fuzzyStr.toString());
			return fuzzyName.toString();
		} else if (name.length() == 2) {
			fuzzyName = name.deleteCharAt(1).append("*");
			return fuzzyName.toString();
		}
		return fuzzyStr.toString();
	}

	@Test
	public void fuzzyTest(){
		String s = "ysy ઇଓ";
		System.out.println(fuzzyUserNickname(s));
	}
}
