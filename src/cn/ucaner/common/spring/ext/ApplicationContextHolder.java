/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
* @Package：cn.ucaner.common.spring.ext   
* @ClassName：ApplicationContextHolder   
* @Description：   <p> 一个特殊的bean,可以在Spring {@code ApplicationContext}中定义,
* 					  以静态地使用上下文 对于任何出于某种原因不能在Spring中连接的对象(例如，日志程序必须是这样的)
* 					  定义在XML或用于初始化日志系统的属性文件中.</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月24日 上午11:53:14   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class ApplicationContextHolder implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

	private static ApplicationContext applicationContext;
	private static volatile boolean refreshed;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		refreshed = true;
	}

	/**
	 * 确保{@ code ApplicationContext}已经设置为< i >和< /i >，它已被刷新。刷新
	 * 事件是在上下文已经完全启动时发送的，这意味着所有bean都已经创建好了 初始化成功。
	 * @return
	 */
	public static boolean hasApplicationContext() {
		return ( refreshed && applicationContext != null );
	}

	/**
	 * 检索在Spring创建和初始化holder bean时设置的{@ code ApplicationContext}。如果
	 * holder没有被创建(请参阅类文档了解如何连接holder)，
	 * 或者如果holder未初始化，此访问器可能返回{@ code null}。
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;
	}

	/**
	 * 返回指示是否刷新{@ code ApplicationContext}的标志。从理论上讲,这是
	 *当{@ link # hasApplicationContext()}返回{@ code false}时，此方法可以返回{@ code true}，
	 *但是在实践中，这是非常不可能的，因为所有者的bean应该已经创建并初始化了在刷新事件之前。
	 * @return
	 */
	public static boolean isRefreshed() {
		return refreshed;
	}
}
