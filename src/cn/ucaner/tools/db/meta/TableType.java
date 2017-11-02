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
package cn.ucaner.tools.db.meta;

/**
 * 元信息中表的类型
 * @author Looly
 *
 */
public enum TableType {
	TABLE("TABLE"),
	VIEW("VIEW"),
	SYSTEM_TABLE ("SYSTEM TABLE"),
	GLOBAL_TEMPORARY("GLOBAL TEMPORARY"),
	LOCAL_TEMPORARY("LOCAL TEMPORARY"),
	ALIAS("ALIAS"),
	SYNONYM("SYNONYM");
	
	private String value;
	/**
	 * 构造
	 * @param value 值
	 */
	TableType(String value){
		this.value = value;
	}
	/**
	 * 获取值
	 * @return 值
	 */
	public String value(){
		return this.value;
	}
}
