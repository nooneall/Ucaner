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
package cn.ucaner.tools.cron.pattern.matcher;

import java.util.List;


/**
 * 年匹配<br>
 * 考虑年数字太大，不适合boolean数组，单独使用列表遍历匹配
 * @author Looly
 *
 */
public class YearValueMatcher implements ValueMatcher{
	
	private List<Integer> valueList;
	
	public YearValueMatcher(List<Integer> intValueList) {
		this.valueList = intValueList;
	}

	@Override
	public boolean match(Integer t) {
		return valueList.contains(t);
	}
}
