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

/**
 * @Project: easy_health 
 * @Package: com.sunshine.platform.ordermanager
 * @ClassName: PlatFromCodeEnum
 * @Description: <p>平台来源编码</p>
 * @JDK version used: 
 * @Author: 钟乳石
 * @Create Date: 2017年6月12日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public enum PlatFromCodeEnum {
	
  YLAPP("医程通"),WEIXIN("微信");
  private String platFromCodeLabel;

  private PlatFromCodeEnum(String platFromCodeLabel) {
		this.platFromCodeLabel = platFromCodeLabel;
  }

  public String getPlatFromCodeLabel() {
	return platFromCodeLabel;
  }
  
}
