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
package cn.ucaner.task;

/**
* @Package：cn.ucaner.task   
* @ClassName：TaskConstant   
* @Description：   <p> 采集任务常量类</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月25日 下午5:33:26   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class TaskConstant {
	
	/**
	 * 每核Cpu负载的最大线程队列数
	 */
	public static final float POOL_SIZE = 1.5f;

	public static final int threadNum;

	static {
		int cpuNums = Runtime.getRuntime().availableProcessors();
		float MathNum = cpuNums * TaskConstant.POOL_SIZE;
		threadNum = (int) MathNum;
	}
}
