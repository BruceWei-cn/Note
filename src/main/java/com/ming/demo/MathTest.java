package com.ming.demo;

import java.security.SecureRandom;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/7/2 15:57
 * @description
 */
public class MathTest {


	@Test
	public void test01(){
		SecureRandom random = new SecureRandom();
		// [1,60]
		int i = random.nextInt(60) + 1;
		System.out.println("i = " + i);
	}

}
