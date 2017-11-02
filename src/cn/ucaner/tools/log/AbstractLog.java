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
package cn.ucaner.tools.log;

import java.io.Serializable;

import cn.ucaner.tools.core.util.StrUtil;
import cn.ucaner.tools.log.level.Level;

/**
 * 抽象日志类<br>
 * 实现了一些通用的接口
 * 
 * @author Looly
 *
 */
public abstract class AbstractLog implements Log, Serializable{
	private static final long serialVersionUID = -3211115409504005616L;
	
	@Override
	public boolean isEnabled(Level level) {
		switch (level) {
			case TRACE:
				return isTraceEnabled();
			case DEBUG:
				return isDebugEnabled();
			case INFO:
				return isInfoEnabled();
			case WARN:
				return isWarnEnabled();
			case ERROR:
				return isErrorEnabled();
			default:
				throw new Error(StrUtil.format("Can not identify level: {}", level));
		}
	}

	@Override
	public void trace(Throwable t) {
		this.trace(t, t.getMessage());
	}
	
	@Override
	public void debug(Throwable t) {
		this.debug(t, t.getMessage());
	}
	
	@Override
	public void info(Throwable t) {
		this.info(t, t.getMessage());
	}
	
	@Override
	public void warn(Throwable t) {
		this.warn(t, t.getMessage());
	}
	
	@Override
	public void error(Throwable t) {
		this.error(t, t.getMessage());
	}
}
