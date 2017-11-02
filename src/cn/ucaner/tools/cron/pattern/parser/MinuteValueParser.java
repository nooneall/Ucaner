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

/**
 * 分钟值处理
 * @author Looly
 *
 */
public class MinuteValueParser extends SimpleValueParser{
	
	public MinuteValueParser() {
		super(0, 59);
	}

}
