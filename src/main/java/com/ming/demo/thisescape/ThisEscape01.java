package com.ming.demo.thisescape;

/**
 * @author Ming
 * <P>2021/9/17 14:58</P>
 * <P>模拟this指针逃逸,定义：在构造器构造还未初始化完成前,即实例初始化阶段还未完成，将自身this引用向外抛出并被其他线程复制
 * （访问）了该引用，可能会访问到该this引用还未被初始化的变量，造成异常</P>
 */
public class ThisEscape01 {

	/**
	 * final常量会保证在构造器内完成初始化（但是仅限于未发生this逃逸的情况下，具体可以看多线程对final保证可见性的实现）
	 */
	final int i;
	int j = 0;
	static ThisEscape01 obj;

	public ThisEscape01() {
		this.i = 1;
		j = 1;
		// 将this逃逸抛出给线程B（ThreadA存在，此处指向可被注释）
//		obj = this;
	}

	public static void main(String[] args) {
		//线程A：模拟构造器中this逃逸,将未构造完全对象引用抛出
		Thread threadA = new Thread(() -> {
			//构造初始化中...线程B可能获取到还未被初始化完成的变量
			//类似于this逃逸，但并不一定发生
			obj = new ThisEscape01();
		});


		// 线程B:读取对象引用，访问i/j变量；
		Thread threadB = new Thread(() -> {
			//可能会发生初始化失败的情况解释：实例变量i的初始化被重排序到构造器外，此时1还未被初始化
			ThisEscape01 objB = obj;
			try {
				System.out.println(objB.j);
			} catch (NullPointerException e) {
				System.out.println("发生空指针错误：普通变量j未被初始化");
			}
			try {
				System.out.println(objB.i);
			} catch (NullPointerException e) {
				System.out.println("发生空指针错误：final变量i未被初始化");
			}
		});
		// 此处模拟A线程初始化obj对象，避免B线程访问到还未被初始化的对象（但因为多线程执行先后的原因，可能依然会发生this逃逸，即B访问违背完全初始化的对象）
		threadA.start();
		threadB.start();
	}
}
