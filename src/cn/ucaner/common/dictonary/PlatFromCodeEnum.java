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

/**
* @Package：cn.ucaner.common.dictonary   
* @ClassName：PlatFromCodeEnum   
* @Description：   <p> 平台来源编码</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:47:54   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public enum PlatFromCodeEnum {
	
  YLAPP("Ucaner"),WEIXIN("PlatFrom");
  private String platFromCodeLabel;

  private PlatFromCodeEnum(String platFromCodeLabel) {
		this.platFromCodeLabel = platFromCodeLabel;
  }

  public String getPlatFromCodeLabel() {
	return platFromCodeLabel;
  }
  
}
