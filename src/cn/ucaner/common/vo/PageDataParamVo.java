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

import java.util.List;

/**
* @Package：cn.ucaner.common.vo   
* @ClassName：PageDataParamVo   
* @Description：   <p> 分页返回数据通用VO</p>
* @Author： - DaoDou 
* @CreatTime：2017年11月19日 下午7:31:19   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class PageDataParamVo {

	/**
	 * 记录总数
	 */
	private Long totalItems;

	/**
	 * 分页记录集合
	 */
	private List<?> dataList;

	/**
	 * @param totalItems
	 * @param dataList
	 */
	public PageDataParamVo(long totalItems, List<?> dataList) {
		super();
		this.totalItems = totalItems;
		this.dataList = dataList;
	}

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

}
