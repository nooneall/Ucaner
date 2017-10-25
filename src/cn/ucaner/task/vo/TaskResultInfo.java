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
package cn.ucaner.task.vo;

/**
* @Package：cn.ucaner.task.vo   
* @ClassName：TaskResultInfo   
* @Description：   <p> 任务执行返回的结果值对象 </p>
* @Author： - DaoDou 
* @CreatTime：2017年10月25日 下午5:32:58   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class TaskResultInfo {

	/**
	 * 任务id
	 */
	private String interfaceId;

	/**
	 * 任务结果对象
	 */
	private Object taskResult;

	/**
	 * 采集描述信息
	 */
	private String collectCallMsg;

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public Object getTaskResult() {
		return taskResult;
	}

	public void setTaskResult(Object taskResult) {
		this.taskResult = taskResult;
	}

	public String getCollectCallMsg() {
		return collectCallMsg;
	}

	public void setCollectCallMsg(String collectCallMsg) {
		this.collectCallMsg = collectCallMsg;
	}
	
}
