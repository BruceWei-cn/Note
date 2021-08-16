package com.ming.demo;

import com.google.common.collect.Maps;
import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/6/29 15:43
 * @Description: 数据结构测试
 */
public class TreeMapTest {

	@Test
	public void test01() {
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		SortedMap<Integer, String> treeMapIncl;

		// populating tree map,key不允许重复，存入相同Key后入的值会覆盖前一个
		treeMap.put(2, "two");
		treeMap.put(1, "one");
		treeMap.put(1, "one1");
		treeMap.put(3, "three");
		treeMap.put(6, "six");
		treeMap.put(5, "five");
		// treeMap底层会排序
		System.out.println("TreeMap's size: " + treeMap.size() + ", treeMap = " + treeMap);

		System.out.println("Getting tail map");
		// 返回值类型：SortMap -> 获得TreeMap内比fromKey大的key
		treeMapIncl = treeMap.tailMap(3, false);
		System.out.println("Tail map values: " + treeMapIncl);

		// 返回值类型：SortMap -> 获得TreeMap内比toKey小的key（不包含等于）
		treeMapIncl = treeMap.headMap(3);
		System.out.println("Head map values: " + treeMapIncl);

		System.out.println("First key is: " + treeMap.firstKey());
		System.out.println("Last key is:" + treeMap.lastKey());
	}

	/**
	 * TreeMap可以用于抽奖：利用TreeMap的有序性，将抽奖权重视为key,可将其key的组成视为一组从小到大有序的数组
	 * <p>随机值随机落在区间范围，根据tailMap(),firstKey()来随机获取一个key;再根据key获取对应的Value,Value可以是奖品id</p>
	 */
	@Test
	public void lotteryTest() {
		TreeMap<Double, String> treeMap = Maps.newTreeMap();
		SortedMap<Double, String> sortedMap;
		// key理解为"累计"权重值（eg: 二等奖单独将的权重为 -> 3.6-0.35），所有权重加在一起可以为任意数，因为抽奖是依据权重比列来确定的
		treeMap.put(0.88, "一等奖");
		treeMap.put(8.0, "三等奖");
		treeMap.put(3.6, "二等奖");
		treeMap.put(13.0, "四等奖");
		treeMap.put(25.0, "五等奖");
		System.out.println("treeMap = " + treeMap);
		double randomVal = treeMap.lastKey() * Math.random();
		System.out.println("randomVal = " + randomVal);

		sortedMap = treeMap.tailMap(randomVal, true);
		System.out.println("sortedMap = " + sortedMap);

		Double level = treeMap.tailMap(randomVal).firstKey();
		System.out.println("恭喜你抽中了：" + treeMap.get(level));
	}
}
