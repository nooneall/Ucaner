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
package cn.ucaner.common.vo;

import java.util.LinkedHashMap;
import java.util.Map;

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
