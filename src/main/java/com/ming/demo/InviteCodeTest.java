package com.ming.demo;

import java.security.SecureRandom;
import java.util.Random;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/1/11 15:58
 * @Description: 唯一邀请码
 */
public class InviteCodeTest {

	@Test
	public void test01(){
		int  maxNum = 36;
		int i;
		int count = 0;
		char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuilder pwd = new StringBuilder();
		Random r = new SecureRandom();
		while(count < 8){
			i = Math.abs(r.nextInt(maxNum));
			pwd.append(str[i]);
			count ++;
		}
		System.out.println(pwd.toString());
	}
}
