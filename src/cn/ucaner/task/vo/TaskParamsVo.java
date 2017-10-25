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

import java.io.Serializable;

/**
* @Package：cn.ucaner.task.vo   
* @ClassName：TaskParamsVo   
* @Description：   <p> 任务参数对象 </p>
* @Author： - DaoDou 
* @CreatTime：2017年10月25日 下午5:33:11   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class TaskParamsVo implements Serializable {

	private static final long serialVersionUID = 4709829787614681051L;
	
	private String interfaceId;

	private Object entity;

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

}
