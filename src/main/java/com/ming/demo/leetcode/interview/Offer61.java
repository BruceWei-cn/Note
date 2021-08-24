package com.ming.demo.leetcode.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/24 15:34
 * @description
 */
public class Offer61 {

	@Test
	public void	 test(){
		int[] nums = {11,2,3,5,0};
		System.out.println(isStraight(nums));
	}

	/**
	 * 判断五张牌是否能够组成顺子
	 * <P>充分条件有以下两点:</P>
	 * <P>1. 数组内不能有重复的数字</P>
	 * <P>2. 因为五张牌，所以 max-min<5 </P>
	 * <P>总结：当一个数组，限制了最大最小的相差值（限制范围），同事不允许其内有重复的值，那么这段数组一定连续</P>
	 */
	public boolean isStraight(int[] nums) {
		int min = 14;
		int max = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (num != 0) {
				max = Math.max(max, num);
				min = Math.min(min, num);
				// 除0外，牌不可以重复
				if (set.contains(num)) {
					return false;
				}
				set.add(num);
			}
		}
		return max - min < 5;
	}
}
