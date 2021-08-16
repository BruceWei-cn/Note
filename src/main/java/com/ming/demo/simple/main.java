package com.ming.demo.simple;

/**
 * @author: Ming
 * @Date: 2021/5/12 16:53
 * @Description:
 */
public class main {

	public static void main(String[] args) {
		Sub s = new Sub(); //1
		Base b = s; //0

		System.out.println(s.field); // 1

		System.out.println(b.field); // 0

		System.out.println(((Sub) b).field); // 1

		System.out.println(((Base) s).field); //0
	}

}
