package com.ming.demo.juc;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ming
 * @date 2021/9/3 16:45
 * @description AQS源码分析
 */
public class AQSCodeAnalysis {

	/**
	 * @see  https://www.cnblogs.com/waterystone/p/4920797.html
	 * <p>编写AQS的md，编写coundDownLatch的md,数据库pdf上传，jvm,类加载器*/
	public void no(){
//		AbstractQueuedSynchronizer aqs = new AbstractQueuedSynchronizer();
		ReentrantLock lock = new ReentrantLock();
		lock.unlock();
	}
}
