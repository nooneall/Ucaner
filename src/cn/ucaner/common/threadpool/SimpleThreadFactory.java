/**
 * <html>
 * <body>
 *  <P> Copyright 2014 JasonInternational Ucanx</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 20170828</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

/**
* @Package：cn.ucaner.common.threadpool   
* @ClassName：SimpleThreadFactory   
* @Description：   <p> threadFactory简单实现,改写自DefaultThreadFactory,使线程具有更有意义的名称</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:31:25   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SimpleThreadFactory implements ThreadFactory {
	
	protected static Logger logger = Logger.getLogger(SimpleThreadFactory.class);
	
	/**
	 * AtomicInteger是在使用非阻塞算法实现并发控制,在一些高并发程序中非常适合 by Jason
	 */
	static final AtomicInteger poolNumber = new AtomicInteger(1);
	
	final ThreadGroup group;
	
	final AtomicInteger threadNumber = new AtomicInteger(1);
	
	final String namePrefix;

	public SimpleThreadFactory() {
		SecurityManager s = System.getSecurityManager();
		group = ( s != null ) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
		namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
	}

	public SimpleThreadFactory(String threadPoolName) {
		SecurityManager s = System.getSecurityManager();
		group = ( s != null ) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
		namePrefix = threadPoolName + "-" + poolNumber.getAndIncrement() + "-thread-";
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
		if (t.isDaemon()) {
			t.setDaemon(false);
		}
		if (t.getPriority() != Thread.NORM_PRIORITY) {
			t.setPriority(Thread.NORM_PRIORITY);
		}
		return t;
	}

}
