package com.ming.demo.thisescape;

/**
 * @author Ming
 * <P>模拟this逃逸2：构造器中启动线程</P>
 */
public class ThisEscape02 {

	final int i;
	int j;

	public ThisEscape02() {
		i = 1;
//		j = 1;
		new Thread(new RunnableTest()).start();
	}

	/**
	 * 内部类实现Runnable：引用外部类
	 */
	private class RunnableTest implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println(ThisEscape02.this.j);
			} catch (NullPointerException e) {
				System.out.println("发生空指针错误：普通变量j未被初始化");
			}
			try {
				System.out.println(ThisEscape02.this.i);
			} catch (NullPointerException e) {
				System.out.println("发生空指针错误：final变量i未被初始化");
			}
		}
	}

	public static void main(String[] args) {
		new ThisEscape02();
	}
}
