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
package cn.ucaner.tools.poi.excel.sax;

import java.util.List;

/**
 * Sax方式读取Excel行处理器
 * @author looly
 *
 */
public interface RowHandler {
	
	/**
	 * 处理一行数据
	 * @param sheetIndex 当前Sheet序号
	 * @param rowIndex 当前行号
	 * @param rowlist 行数据列表
	 */
	void handle(int sheetIndex, int rowIndex, List<String> rowlist);
}
