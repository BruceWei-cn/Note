package com.ming.demo.conding.interview;

/**
 * @author Ming
 * @date 2021/8/13 16:19
 * @description
 */
public class Offer04 {

	/**
	 * 二维数组中的查找某个元素是否存在
	 */
	public static void main(String[] args) {
		int[][] ints = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}};
		int[][] ints2 = {{-5}};
		System.out.println(find(ints, 5));
		System.out.println(find02(ints2, -5));
	}

	/**
	 * 使用暴力破解
	 */
	private static Boolean find(int[][] ints, int target) {
		for (int[] ints1 : ints) {
			for (int i : ints1) {
				if (i == target) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * <P>先大到小（右 -> 左）比较单行的每列值，比目标值大说明目标值可能在列的左边，坐标-1</P>
	 * <p>若列中没有则向下一行移动，重复步骤一</p>
	 */
	private static boolean find02(int[][] ints, int target) {
		if (ints == null || ints.length == 0 || ints[0].length == 0) {
			return false;
		}
		int rows = ints.length;
		int columns = ints[0].length;
		int row = 0;
		int column = columns - 1;
		while (row < rows && column >= 0) {
			int num = ints[row][column];
			if (num == target) {
				return true;
			} else if (num > target) {
				column--;
			}
			// 说明上一行的列中的值，要么比目标值大要么比目标值小；那么向下移动一行继续以上逻辑判断；
			else {
				row++;
			}
		}
		return false;
	}
}
