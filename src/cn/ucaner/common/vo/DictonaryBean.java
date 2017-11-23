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
package cn.ucaner.common.vo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
* @Package：cn.ucaner.common.vo   
* @ClassName：DictonaryBean   
* @Description：   <p> 字典</p>
* @Author： - DaoDou 
* @CreatTime：2017年11月19日 下午7:30:22   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class DictonaryBean {
    private  static Map<String,String> platformCodeDic = new LinkedHashMap<String,String>();
    private  static Map<Integer,String> orderStatusDic = new LinkedHashMap<Integer,String>();
    
  
    
    private static Map<Integer,String> orderChangeRecordDic = new LinkedHashMap<Integer,String>();
    static{
    	
    }

	public static Map<String, String> getPlatformCodeDic() {
		return platformCodeDic;
	}

	public static void setPlatformCodeDic(Map<String, String> platformCodeDic) {
		DictonaryBean.platformCodeDic = platformCodeDic;
	}

	public static Map<Integer, String> getOrderStatusDic() {
		return orderStatusDic;
	}

	public static void setOrderStatusDic(Map<Integer, String> orderStatusDic) {
		DictonaryBean.orderStatusDic = orderStatusDic;
	}

	public static Map<Integer, String> getOrderChangeRecordDic() {
		return orderChangeRecordDic;
	}

	public static void setOrderChangeRecordDic(Map<Integer, String> orderChangeRecordDic) {
		DictonaryBean.orderChangeRecordDic = orderChangeRecordDic;
	}
}
