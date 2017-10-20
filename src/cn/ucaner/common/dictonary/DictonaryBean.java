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
package cn.ucaner.common.dictonary;

import java.util.LinkedHashMap;
import java.util.Map;

/**
* @Package：cn.ucaner.common.dictonary   
* @ClassName：DictonaryBean   
* @Description：   <p> 字典项配置</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:47:16   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */


public class DictonaryBean {
    private  static Map<String,String> platformCodeDic=new LinkedHashMap<String,String>();
    private  static Map<Integer,String> orderStatusDic=new LinkedHashMap<Integer,String>();
    
    static{
    	for(PlatFromCodeEnum e :PlatFromCodeEnum.values()){
    		platformCodeDic.put(e.name(), e.getPlatFromCodeLabel());
    	}
    	
    	for(OrderStatusEnum e :OrderStatusEnum.values()){
    		orderStatusDic.put(e.getOrderStatus(), e.getOrderStatusLabel());
    	}
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

    
    
}
