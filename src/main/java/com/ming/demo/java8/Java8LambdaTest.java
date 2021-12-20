package com.ming.demo.java8;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/5/7 13:41
 * @Description: java8语法糖
 */
public class Java8LambdaTest {

	/**
	 * Important: JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
	 */
	public static class AcceptMethod {

		public static void printValue(String str) {
			System.out.println("print value : " + str);
		}

		public static void main(String[] args) {
			List<String> al = Arrays.asList("a", "b", "c", "d");
			for (String a : al) {
				AcceptMethod.printValue(a);
			}
			//下面的for each循环和上面的循环是等价的
			al.forEach(x -> {
				AcceptMethod.printValue(x);
			});
			// 等价于
			al.forEach(AcceptMethod::printValue);
		}
	}

	@Test
	public void test() {
		List<String> al = Arrays.asList("a", "b", "c", "d");
		al.forEach(AcceptMethod::printValue);
		// 下面的方法和上面等价
		Consumer<String> method = AcceptMethod::printValue;
		al.forEach(x -> method.accept(x));
		// 等价于
		al.forEach(method);
	}

	/**
	 * 日常开发中遇到一种场景：一个键映射到多个值 -> Map<K,List<V>>
	 */
	@Test
	public void computeIfAbsentTest() {
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("Ming", 666);
		// 若map中key对应的value不存在，则会将mappingFunction计算产生的值作为保存改 key的value并且返回该值。 // val =666
		Object val = hashMap.computeIfAbsent("Ming", key -> new ArrayList<>());
		System.out.println("val = " + val);
		// 若不做任何计算，则之间返回该key所对应的value : val = []
		Object min = hashMap.computeIfAbsent("Min", key -> new ArrayList<>());
		System.out.println("min = " + min);
	}

	/**
	 * putIfAbsent与上面的方法类似但是不同处在于，当Map中key所对应的value不存在时，puIfAbsent将直接返回null
	 */
	@Test
	public void putIfAbsentTest() {
		HashMap<Object, Object> map = Maps.newHashMap();
		map.put("Ming", 666);
		// 值存在时直接返回值
		Object val = map.putIfAbsent("Ming", new ArrayList<>());
		System.out.println("ming = " + val);
	}

	@Test
	public void flatMapTest() {
		List<String> list = Stream.of("Hello", "World")
				.flatMap(str -> Arrays.stream(str.split(""))).distinct()
				.collect(Collectors.toList());
		System.out.println("list = " + list);

		List<Stream<String>> collect = Stream.of("Hello", "World").map(s -> Arrays.stream(s.split("")))
				.distinct()
				.collect(Collectors.toList());
		System.out.println("collect = " + collect);
	}

	@Test
	public void optionalTest() throws Exception {
		TeamUserEntity teamUserEntity = Optional.ofNullable(getEntity())
				.filter(e -> e.getTeamId() != 0)
				.map(e -> e.setFormatDate("2021-07-15"))
				.orElseThrow(Exception::new);
		System.out.println("teamUserEntity = " + teamUserEntity);
		TeamUserEntity entity = Optional.ofNullable(getEntity())
				.filter(e -> e.getTeamId() == 0)
				.map(e -> e.setFormatDate("2021-07-15"))
				.orElse(TeamUserEntity.builder()
						.leaderFlag(1)
						.playFlag(1)
						.teamId(0L)
						.userId(74398594L)
						.formatDate("2021-07-16")
						.build());
		System.out.println("entity = " + entity);
		Optional.ofNullable(getEntity())
				.filter(e -> e.getTeamId() == 0)
				.map(e -> e.setFormatDate("2021-07-15"))
				.orElseGet(() -> {
					System.out.println();
					return TeamUserEntity.builder()
							.leaderFlag(1)
							.playFlag(1)
							.teamId(0L)
							.userId(74398594L)
							.formatDate("2021-07-16")
							.build();
				});
	}

	private TeamUserEntity getEntity() {
		TeamUserEntity entity = new TeamUserEntity();
		return entity.setLeaderFlag(1)
				.setPlayFlag(1)
				.setTeamId(34782734L)
				.setUserId(723740930L)
				.setFormatDate("2021-01-15");
	}

	@Test
	public void mapAndFlatMapTest() {
		String[] words = new String[]{"Hello", "World"};
		// map返回的流实际上是Stream<String[]>类型
		List<String[]> list = Arrays.stream(words).sequential()
				.map(w -> w.split(""))
				// 此处得到的结果是包含两个 String[]的list
				.collect(Collectors.toList());
		System.out.println("list = " + list);

		List<String> strings = Arrays.stream(words)
				// 将单词切割为一个一个字母 -> Stream<String[]>
				.map(w -> w.split(""))
				// flatMap将 Arrays::stream生成的单个流合并起来，扁平化为一个流
				// Arrays::stream 返回以指定数组为源的序列流
				// 此时内部： Stream<String>
				.flatMap(Arrays::stream)
				// 再将扁平化之后的整理为一个List集合
				.collect(Collectors.toList());
		System.out.println("strings = " + strings);
		strings.forEach(System.out::print);
	}

	@Test
	public void flatMapTest02(){
		ArrayList<Integer> list1 = Lists.newArrayList();
		ArrayList<Integer> list2 = Lists.newArrayList();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		// 将list1和list2扁平化之后再合并
		List<Integer> result = Stream.of(list1, list2).flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println("合并之后："+result);
	}
}
