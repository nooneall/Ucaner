/**
 * <html>
 * <body>
 *  <P> Copyright 2014 广东天泽阳光康众医疗投资管理有限公司. 粤ICP备09007530号-15</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2017年9月13日</p>
 *  <p> Created by x-lan</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.vo;

import java.util.List;

/**
 * @Project: easy_health_client 
 * @Package: com.sunshine.common.vo
 * @ClassName: PageDataVo
 * @Description: <p>分页返回数据通用VO</p>
 * @JDK version used: 
 * @Author: x-lan
 * @Create Date: 2017年9月13日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
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
