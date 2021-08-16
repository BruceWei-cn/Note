package com.ming.demo.note;

/**
 * @author Ming
 * @date 2021/7/29 10:41
 * @description
 */
public class Note {

	/**
	 * JMM（可见性，原子性，有序性）
	 * 关于可见性三个原则：
	 * 	一. Happens-Before原则
	 * 			1.定义： 对于两个操作A和B,这两个操作可以在不同的线程中执行。如果A Happens-Before B
	 * 		那么可以保证，A操作执行结果对B是可见的
	 *
	 * 二. 锁定规则
	 * 			1.定义：对于一个锁的解锁总是Happens-Before 对于这个锁的加锁
	 *      注：Synchronized 能够保证可见性的原理就是：能够刷新主存 和 原子化多个操作
	 *
	 * 三. Volatile规则
	 * 			1.定义：对于一个volatile修饰变量的写总是 Happens-before对于这个变量的读
	 * 		原理：1> 刷新主存  2> 禁止重排序
	 */
	public void noteNote(){}
}
