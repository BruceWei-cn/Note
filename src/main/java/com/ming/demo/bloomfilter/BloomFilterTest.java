package com.ming.demo.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/5/31 16:27
 * @Description:
 */
public class BloomFilterTest {

	@Test
	public void myBloomFilterTest() {
		String value1 = "https://javaguide.cn/";
		String value2 = "https://github.com/Snailclimb";
		MyBloomFilter bloom = new MyBloomFilter();
		System.out.println(bloom.contains(value1));
		System.out.println(bloom.contains(value2));
		bloom.add(value1);
		bloom.add(value2);
		System.out.println(bloom.contains(value1));
		System.out.println(bloom.contains(value2));
	}

	@Test
	public void googleBloomFilterTest() {
		// 创建布隆过滤器，最多方1500个整数，可容忍误差率为0.01
		BloomFilter<Integer> filter = BloomFilter
				.create(Funnels.integerFunnel(), 1500, 0.01);
		// 判断指定元素是否存在
		System.out.println(filter.mightContain(1));
		System.out.println(filter.mightContain(2));
		filter.put(1);
		filter.put(2);
		// 当为true时，可以99%确定该元素再过滤器中
		// 当为false时，可以100%确定该元素不存在于过滤器中
		System.out.println(filter.mightContain(1));
		System.out.println(filter.mightContain(2));
	}
}
