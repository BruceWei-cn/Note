package com.ming.demo;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import org.junit.Test;
import sun.misc.BASE64Decoder;

/**
 * @author: Ming
 * @Date: 2020/11/30 10:59
 * @Description:
 */
public class base64Demo {


	@Test
	public void test01() throws IOException {
		String base64Number = "NDEyNzI3MTk4MzA3MjQzNTYx";
		byte[] bytes = new BASE64Decoder().decodeBuffer(base64Number);
		String s = new String(bytes, "utf-8");
		System.out.println("s = " + s);
	}

	@Test
	public void test02(){
		String base64Number = "NDEyNzI3MTk4MzA3MjQzNTYx";
		Decoder decoder = Base64.getDecoder();
		String string = new String(decoder.decode(base64Number));
		System.out.println("string = " + string);
	}

}
