/**
 * <html>
 * <body>
 *  <P> Copyright 2014 广东天泽阳光康众医疗投资管理有限公司. 粤ICP备09007530号-15</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2017年6月12日</p>
 *  <p> Created by 钟乳石</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.dictonary;

import java.util.LinkedHashMap;
import java.util.Map;

/**
* @Package：cn.ucaner.common.dictonary   
* @ClassName：DictonaryBean   
* @Description：   <p> 字典匹配</p>
* @Author： - DaoDou 
* @CreatTime：2017年9月15日 下午2:35:36   
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
