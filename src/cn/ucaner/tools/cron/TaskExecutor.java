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
package cn.ucaner.tools.cron;

import cn.ucaner.tools.cron.task.Task;

/**
 * 作业执行器<br>
 * 执行具体的作业，执行完毕销毁
 * @author Looly
 *
 */
public class TaskExecutor extends Thread{
	
	private Scheduler scheduler;
	private Task task;
	
	/**
	 * 获得任务对象
	 * @return 任务对象
	 */
	public Task getTask() {
		return task;
	}

	public TaskExecutor(Scheduler scheduler, Task task) {
		this.scheduler = scheduler;
		this.task = task;
	}
	
	@Override
	public void run() {
		try {
			scheduler.listenerManager.notifyTaskStart(this);
			task.execute();
			scheduler.listenerManager.notifyTaskSucceeded(this);
		} catch (Exception e) {
			scheduler.listenerManager.notifyTaskFailed(this, e);
		}finally{
			scheduler.taskExecutorManager.notifyExecutorCompleted(this);
		}
	}
}
