package com.ming.demo.conding.interview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Ming
 * @date 2021/8/13 11:30
 * @description
 */
public class Offer50 {

	/**
	 * 寻找字符串中第一次出现且只出现一次的字符
	 */
	public static void main(String[] args) {
		String s = "abaccdeff";
		System.out.println(findFirst(s));
		System.out.println(findFirst2(s));
	}

	private static char findFirst(String s) {
		char c = ' ';
		if (StringUtils.isEmpty(s)) {
			return c;
		}
		// 利用hash表
		HashMap<Character, Boolean> map = new HashMap<>();
		char[] chars = s.toCharArray();
		for (char ch : chars) {
			// map中若有同样的key会更新value
			map.put(ch, !map.containsKey(ch));
		}
		for (char aCh : chars) {
			if (Boolean.TRUE.equals(map.get(aCh))) {
				return aCh;
			}
		}
		return c;
	}

	private static char findFirst2(String s) {
		char c = ' ';
		if ("".equals(s)) {
			return c;
		}
		LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
		char[] chars = s.toCharArray();
		for (char ch : chars) {
			map.put(ch, !map.containsKey(ch));
		}
		for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
			if (entry.getValue().equals(Boolean.TRUE)) {
				return entry.getKey();
			}
		}
		return c;
	}
}
