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
package cn.ucaner.components.core.utils;

import java.util.UUID;

/**
* @Package：cn.ucaner.components.core.utils   
* @ClassName：UUIDUtil   
* @Description：   <p> UUIDUtil  </p>
* @Author： - DaoDou 
* @CreatTime：2017年11月23日 下午11:32:21   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class UUIDUtil {
	/**
	 * 获取字符串UUID（除掉"-"）
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}
}
