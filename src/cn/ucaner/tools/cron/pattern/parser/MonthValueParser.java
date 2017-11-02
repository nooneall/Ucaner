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
package cn.ucaner.tools.cron.pattern.parser;

import cn.ucaner.tools.cron.CronException;

/**
 * 月份值处理
 * 
 * @author Looly
 *
 */
public class MonthValueParser extends SimpleValueParser {

	/** Months aliases. */
	private static final String[] ALIASES = { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" };

	public MonthValueParser() {
		super(1, 12);
	}
	
	@Override
	public int parse(String value) throws CronException {
		try {
			return super.parse(value);
		} catch (Exception e) {
			return parseAlias(value);
		}
	}

	/**
	 * 解析别名
	 * @param value 别名值
	 * @return 月份int值
	 * @throws CronException
	 */
	private int parseAlias(String value) throws CronException {
		for (int i = 0; i < ALIASES.length; i++) {
			if (ALIASES[i].equalsIgnoreCase(value)) {
				return i + 1;
			}
		}
		throw new CronException("Invalid month alias: {}", value);
	}
}
